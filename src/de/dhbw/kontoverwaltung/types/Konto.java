package de.dhbw.kontoverwaltung.types;

import de.dhbw.kontoverwaltung.types.personen.Person;

public class Konto {

	private Bank bank;
	private String kontoId;
	private Person inhaber;
	private Betrag betrag;
	private Pin pin;

	public Konto(Bank bank, String kontoId, Person inhaber, Betrag betrag, Pin pin) {
		super();
		this.bank = bank;
		this.kontoId = kontoId;
		this.inhaber = inhaber;
		this.betrag = betrag;
		this.pin = pin;
	}

	public Betrag getBetrag() {
		return betrag;
	}

	public void setBetrag(Betrag betrag) {
		this.betrag = betrag;
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public Bank getBank() {
		return bank;
	}

	public String getKontoId() {
		return kontoId;
	}

	public Person getInhaber() {
		return inhaber;
	}

}
