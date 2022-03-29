package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

import de.dhbw.kontoverwaltung.types.personen.Person;
import de.dhbw.kontoverwaltung.util.UniqueIdGenerator;

public class GiroKonto implements Serializable {

	private Bank bank;
	private String kontoId;
	private Person inhaber;
	private Pin pin;
	private EuroCentBetrag betrag;

	public GiroKonto(Bank bank, Person inhaber, Pin pin) {
		super();
		this.bank = bank;
		this.inhaber = inhaber;
		this.pin = pin;
		this.kontoId = UniqueIdGenerator.next();
		this.betrag = new EuroCentBetrag(0, 0);
	}

	public EuroCentBetrag getBetrag() {
		return betrag;
	}

	public void setBetrag(EuroCentBetrag betrag) {
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

	@Override
	public String toString() {
		return "Konto [Bank=" + bank + ", KontoID=" + kontoId + ", Inhaber=" + inhaber + ", Pin=" + pin + ", Betrag="
				+ betrag + "]";
	}
	
}
