package de.dhbw.kontoverwaltung.types.personen;

import java.io.Serializable;

public abstract class Person implements Serializable {

	private String vorname;
	private String nachname;

	public Person(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

}
