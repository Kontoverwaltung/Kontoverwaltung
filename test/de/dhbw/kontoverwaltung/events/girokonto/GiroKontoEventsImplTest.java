package de.dhbw.kontoverwaltung.events.girokonto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.GiroKontoRepo;
import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.repositories.returns.GiroKontoReturn;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;
import de.dhbw.kontoverwaltung.types.Person;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.Person.PersonBuilder;
import de.dhbw.kontoverwaltung.types.transaktion.Transaktion;

@TestMethodOrder(OrderAnnotation.class)
class GiroKontoEventsImplTest {

	private static final Pin PIN = new Pin("1234");
	private static final String PIN_STRING = "1234";
	private static final String PIN_STRING_NEW = "1235";
	private static String kontoId;
	private static GiroKonto konto = null;
	
	private static final String BANK_NAME = "testbank";
	private static Bank bank = new Bank("testbank");
	
	private static final String VORNAME = "Max";
	private static final String NACHNAME = "Muster";
	private static Person kunde = new Person.PersonBuilder().vorname("Max").nachname("Muster").build();
	
	private GiroKontoRepo giroKontoRepo = new GiroKontoRepo() {
		
		@Override
		public GiroKontoReturn updatePin(GiroKonto giroKonto, Pin newPin) {
			assertThat(giroKonto, is(konto));
			konto.setPin(newPin);
			return new GiroKontoReturn(true, konto);
		}
		
		@Override
		public GiroKontoReturn updateBetrag(GiroKonto giroKonto, EuroCentBetrag betrag) {
			assertThat(giroKonto, is(konto));
			konto.setBetrag(betrag);
			return new GiroKontoReturn(true, konto);
		}
		
		@Override
		public GiroKontoReturn updateBank(GiroKonto giroKonto, Bank newBank) {
			assertThat(giroKonto, is(konto));
			konto.setBank(newBank);
			return new GiroKontoReturn(true, konto);
		}
		
		@Override
		public GiroKontoReturn removeGiroKonto(GiroKonto giroKonto) {
			assertThat(giroKonto.getKontoId(), is(konto.getKontoId()));
			konto = null;
			return new GiroKontoReturn(true, konto);
		}
		
		@Override
		public GiroKontoReturn getGiroKontoById(String giroKontoId) {
			if (konto != null && giroKontoId.equals(konto.getKontoId())) {
				return new GiroKontoReturn(true, konto);
			} else {
				return new GiroKontoReturn(false, null);
			}
		}
		
		@Override
		public GiroKontoReturn addHistoryEntry(GiroKonto giroKonto, Transaktion transaktion) {
			assertThat(giroKonto, is(konto));
			konto.addHistoryEntry(transaktion);
			return new GiroKontoReturn(true, konto);
		}
		
		@Override
		public GiroKontoReturn addGiroKonto(Bank bankRequest, Person inhaber, Pin pinRequest) {
			assertThat(bankRequest, is(bank));
			assertThat(inhaber, is(kunde));
			assertTrue(pinRequest.isCorrectPin(PIN_STRING));
			konto = new GiroKonto(bank, inhaber, PIN);
			return new GiroKontoReturn(true, konto);
		}
	};
	
	
	private BankRepo bankRepo = new BankRepo() {
		
		@Override
		public BankReturn removeBank(Bank bank) {
			assertThat(bank.getName(), is(BANK_NAME));
			bank = null;
			return new BankReturn(true, bank);
		}

		@Override
		public BankReturn getBankByName(String bankName) {
			if (bank != null && bankName.equals(BANK_NAME)) {
				return new BankReturn(true, bank);
			} else {
				return new BankReturn(false, null);
			}
		}

		@Override
		public BankReturn addBank(String bankName) {
			assertThat(bankName, is(BANK_NAME));
			bank = new Bank(bankName);
			return new BankReturn(true, bank);
		}
	};
	
	
	private KundeRepo kundeRepo = new KundeRepo() {
		
		@Override
		public KundeReturn removeKunde(Person kunde) {
			assertThat(kunde.getKundenId(), is(kunde.getKundenId()));
			kunde = null;
			return new KundeReturn(true, kunde);
		}
		
		@Override
		public KundeReturn getKundeById(String kundenId) {
			if(kunde != null && kundenId.equals(kunde.getKundenId())) {
				return new KundeReturn(true, kunde);
			}
			return new KundeReturn(false, null);
		}
		
		@Override
		public KundeReturn addKunde(String vorname, String nachname) {
			assertThat(vorname, is(VORNAME));
			assertThat(nachname, is(NACHNAME));
			kunde = new PersonBuilder().vorname(vorname).nachname(nachname).build();
			return new KundeReturn(true, kunde);
		}
	};
	
	private GiroKontoEventsImpl target = new GiroKontoEventsImpl(giroKontoRepo, bankRepo, kundeRepo);

	@Test
	@Order(1)
	void testCreateGiroKonto() {
		CommandResult result = target.createNewGiroKonto(BANK_NAME, kunde.getKundenId(), PIN_STRING);
		kontoId = konto.getKontoId();
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("girokonto " + kontoId + " created"));
	}

	@Test
	@Order(2)
	void testGiroKontoFound() {
		CommandResult result = target.getGiroKonto(kontoId);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("Konto [Bank=Bank [Name=testbank], KontoID=" + kontoId + ", Inhaber=Kunde [KundenID=" +kunde.getKundenId()+ "], Pin=Pin [Pin=????], Betrag=Betrag [0,0], Kontoauszug=]"));
	}
	
	@Test
	@Order(3)
	void testChangeBank() {
		CommandResult result = target.changeBank(kontoId, BANK_NAME);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("bank changed"));
	}
	
	@Test
	@Order(4)
	void testChangePin() {
		CommandResult result = target.changePin(kontoId, PIN_STRING, PIN_STRING_NEW);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("pin changed"));
	}
	
	@Test
	@Order(5)
	void testHistoryIsEmpty() {
		CommandResult result = target.getKontoauszug(kontoId);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is(""));
	}

	@Test
	@Order(6)
	void testAutGiroKontoDelete() {
		CommandResult result = target.deleteGiroKonto(kontoId);
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("girokonto deleted"));
	}

	@Test
	@Order(7)
	void testGiroKontoNotFound2() {
		giroKontoNotFound();
	}

	private void giroKontoNotFound() {
		CommandResult result = target.getGiroKonto(kontoId);
		assertThat(result.isSuccessful(), is(false));
		assertThat(result.getAdditionalInfo(), is("failed to load girokonto"));
	}
	
}
