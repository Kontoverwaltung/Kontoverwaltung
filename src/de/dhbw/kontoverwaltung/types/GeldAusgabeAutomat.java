package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

public class GeldAusgabeAutomat implements Serializable {

	private String automatId;

	public GeldAusgabeAutomat(String automatId) {
		super();
		this.automatId = automatId;
	}

	public String getAutomatId() {
		return automatId;
	}

	@Override
	public String toString() {
		return "Automat [AutomatID=" + automatId + "]";
	}
	
}
