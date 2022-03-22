package de.dhbw.kontoverwaltung.types.personen;

import java.io.Serializable;

import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.util.UniqueIdGenerator;

public class Kunde extends Person implements Serializable {

	private String kundenId;
	private Bank bank;

	public Kunde(Bank bank, String vorname, String nachname) {
		super(vorname, nachname);
		this.kundenId = UniqueIdGenerator.next();
		this.bank = bank;
	}

	public String getKundenId() {
		return kundenId;
	}

	public Bank getBank() {
		return bank;
	}

	@Override
	public String toString() {
		return "[vorname=" + vorname + ", nachname=" + nachname + ", bank=" + bank.getName() + "]";
	}

}
