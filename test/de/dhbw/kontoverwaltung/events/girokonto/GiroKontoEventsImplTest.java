package de.dhbw.kontoverwaltung.events.girokonto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

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

	private static GiroKonto konto = null;
	
	private GiroKontoRepo giroKontoRepo = new GiroKontoRepo() {
		
		@Override
		public GiroKontoReturn updatePin(GiroKonto giroKonto, Pin newPin) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public GiroKontoReturn updateBetrag(GiroKonto giroKonto, EuroCentBetrag betrag) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public GiroKontoReturn updateBank(GiroKonto giroKonto, Bank newBank) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public GiroKontoReturn removeGiroKonto(GiroKonto giroKonto) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public GiroKontoReturn getGiroKontoById(String giroKontoId) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public GiroKontoReturn addHistoryEntry(GiroKonto giroKonto, Transaktion transaktion) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public GiroKontoReturn addGiroKonto(Bank bank, Person inhaber, Pin pin) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	private static final String BANK_NAME = "testbank";
	private static Bank bank = null;
	
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
	
	private static final String VORNAME = "Max";
	private static final String NACHNAME = "Muster";
	private static Person kunde = null;
	
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

}
