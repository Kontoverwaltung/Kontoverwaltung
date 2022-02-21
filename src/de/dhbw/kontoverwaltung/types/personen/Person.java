package de.dhbw.kontoverwaltung.types.personen;

public abstract class Person {

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
