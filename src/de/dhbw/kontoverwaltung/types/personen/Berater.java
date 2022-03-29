package de.dhbw.kontoverwaltung.types.personen;

import de.dhbw.kontoverwaltung.types.Bank;

public class Berater extends Person {

	private String beraterId;
	private Bank bank;

	public Berater(String beraterId, Bank bank, String vorname, String nachname) {
		super(vorname, nachname);
		this.beraterId = beraterId;
		this.bank = bank;
	}

	public String getBeraterId() {
		return beraterId;
	}

	public Bank getBank() {
		return bank;
	}

	@Override
	public String toString() {
		return "Berater [BeraterID=" + beraterId + ", Bank=" + bank + "]";
	}
	
}
