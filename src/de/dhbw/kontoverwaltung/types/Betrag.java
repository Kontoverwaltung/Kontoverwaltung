package de.dhbw.kontoverwaltung.types;

public class Betrag {

	private int cent;
	private int euro;

	public Betrag(int cent, int euro) {
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

}
