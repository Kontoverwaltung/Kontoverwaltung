package de.dhbw.kontoverwaltung.types;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.dhbw.kontoverwaltung.types.Person.PersonBuilder;
import de.dhbw.kontoverwaltung.types.transaktion.EinzahlungTransaktion;
import de.dhbw.kontoverwaltung.types.transaktion.Transaktion;

class GiroKontoTest {
	
	private Bank bank = new Bank("testbank");
	private Person kunde = new PersonBuilder().vorname("max").nachname("muster").build();
	private Pin pin = new Pin("1234");
	private GiroKonto konto = new GiroKonto(bank, kunde, pin);
	
	private GeldAusgabeAutomat geldAusgabeAutomat = new GeldAusgabeAutomat("testautomat", new EuroCentBetrag(0, 100));
	
	@BeforeEach
	void setup() {
		konto.setBetrag(new EuroCentBetrag(10, 10));
	}

	@Test
	void testHatMehrGeldAls() {
		assertTrue(konto.hatMehrGeldAls(new EuroCentBetrag(21, 7)));
		assertTrue(konto.hatMehrGeldAls(new EuroCentBetrag(1, 10)));
	}
	
	@Test
	void testHatWenigerGeldAls() {
		assertFalse(konto.hatMehrGeldAls(new EuroCentBetrag(12, 10)));
		assertFalse(konto.hatMehrGeldAls(new EuroCentBetrag(1, 20)));
	}
	
	@Test
	void testTransaktionHistory() {
		Transaktion transaktion = new EinzahlungTransaktion(geldAusgabeAutomat, konto, new EuroCentBetrag(10, 20));
		konto.addHistoryEntry(transaktion);
		String historyString = "EinzahlungTransaktion [GeldAusgabeAutomat=Automat [AutomatID=testautomat], GiroKontoID=" + konto.getKontoId() + ", TransaktionID=" + transaktion.getTransaktionId() + ", Betrag=Betrag [20,10]]\n";
		assertTrue(konto.getHistoryString().equals(historyString));
	}

}
