package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

public class GeldBetrag implements Serializable {

	private int cent;
	private int euro;

	public GeldBetrag(int cent, int euro) {
		super();
		this.cent = cent;
		this.euro = euro;
	}

	public int getCent() {
		return cent;
	}

	public int getEuro() {
		return euro;
	}

	@Override
	public String toString() {
		return "Betrag [" + euro + "," + cent + "€]";
	}
	
}
