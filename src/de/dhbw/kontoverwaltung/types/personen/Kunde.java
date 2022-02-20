package de.dhbw.kontoverwaltung.types.personen;

import de.dhbw.kontoverwaltung.types.Bank;

public class Kunde extends Person {

	private String kundenId;
	private Bank bank;

	public Kunde(String kundenId, Bank bank, String personalausweisId, String vorname, String nachname) {
		super(personalausweisId, vorname, nachname);
		this.kundenId = kundenId;
		this.bank = bank;
	}

	public String getKundenId() {
		return kundenId;
	}

	public Bank getBank() {
		return bank;
	}

}
