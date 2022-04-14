package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.dhbw.kontoverwaltung.types.transaktion.Transaktion;
import de.dhbw.kontoverwaltung.util.UniqueIdGenerator;

public class GiroKonto implements Serializable {

	private Bank bank;
	private String kontoId;
	private Person inhaber;
	private Pin pin;
	private EuroCentBetrag betrag;
	private List<Transaktion> history = new ArrayList<>();

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

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getKontoId() {
		return kontoId;
	}

	public Person getInhaber() {
		return inhaber;
	}

	public String getHistoryString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (Transaktion transaktion : history) {
			stringBuilder.append(transaktion.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	public void addHistoryEntry(Transaktion transaktion) {
		this.history.add(transaktion);
	}

	public boolean hatMehrGeldAls(EuroCentBetrag betragCheck) {
		if (betrag.getEuro() > betragCheck.getEuro()) {
			return true;
		}
		if (betrag.getEuro() < betragCheck.getEuro()) {
			return false;
		}
		if (betrag.getCent() < betragCheck.getCent()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Konto [Bank=" + bank + ", KontoID=" + kontoId + ", Inhaber=" + inhaber + ", Pin=" + pin + ", Betrag="
				+ betrag + ", Kontoauszug=" + getHistoryString() + "]";
	}

}
