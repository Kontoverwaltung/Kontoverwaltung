package de.dhbw.kontoverwaltung.types;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeldAusgabeAutomatTest {
	
	private GeldAusgabeAutomat geldAusgabeAutomat = new GeldAusgabeAutomat("testautomat", new EuroCentBetrag(10, 10));

	@BeforeEach
	void setup() {
		geldAusgabeAutomat.setBetrag(new EuroCentBetrag(10, 10));
	}
	
	@Test
	void testHatMehrGeldAls() {
		assertTrue(geldAusgabeAutomat.hatMehrGeldAls(new EuroCentBetrag(21, 7)));
		assertTrue(geldAusgabeAutomat.hatMehrGeldAls(new EuroCentBetrag(1, 10)));
	}
	
	@Test
	void testHatWenigerGeldAls() {
		assertFalse(geldAusgabeAutomat.hatMehrGeldAls(new EuroCentBetrag(12, 10)));
		assertFalse(geldAusgabeAutomat.hatMehrGeldAls(new EuroCentBetrag(1, 20)));
	}
}
