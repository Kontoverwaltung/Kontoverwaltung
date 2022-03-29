package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

public class GeldAusgabeAutomat implements Serializable {

	private String automatId;
	private EuroCentBetrag betrag;

	public GeldAusgabeAutomat(String automatId,EuroCentBetrag betrag) {
		super();
		this.automatId = automatId;
		this.betrag = betrag;
	}

	public String getAutomatId() {
		return automatId;
	}

	@Override
	public String toString() {
		return "Automat [AutomatID=" + automatId + "]";
	}
	
}
