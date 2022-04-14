package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

public class GeldAusgabeAutomat implements Serializable {

	private String automatId;
	private EuroCentBetrag betrag;

	public GeldAusgabeAutomat(String automatId, EuroCentBetrag betrag) {
		super();
		this.automatId = automatId;
		this.betrag = betrag;
	}

	public String getAutomatId() {
		return automatId;
	}

	public EuroCentBetrag getBetrag() {
		return betrag;
	}

	public void setBetrag(EuroCentBetrag betrag) {
		this.betrag = betrag;
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
		return "Automat [AutomatID=" + automatId + "]";
	}

}
