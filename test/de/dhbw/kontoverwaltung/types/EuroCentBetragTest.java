package de.dhbw.kontoverwaltung.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EuroCentBetragTest {

	private EuroCentBetrag betrag = new EuroCentBetrag(10, 20);
	
	@Test
	void testAdd() {
		EuroCentBetrag summe = betrag.add(new EuroCentBetrag(20,30));
		assertTrue(summe.getCent() == 30 && summe.getEuro() == 50);
	}
	
	@Test
	void testSubstract() {
		EuroCentBetrag differenz = betrag.subtract(new EuroCentBetrag(5,5));
		assertTrue(differenz.getCent() == 5 && differenz.getEuro() == 15);
	}


}
