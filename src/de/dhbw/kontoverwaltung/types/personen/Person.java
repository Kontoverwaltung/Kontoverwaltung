package de.dhbw.kontoverwaltung.types.personen;

public abstract class Person {

	private String personalausweisId;
	private String vorname;
	private String nachname;

	public Person(String personalausweisId, String vorname, String nachname) {
		super();
		this.personalausweisId = personalausweisId;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public String getPersonalausweisId() {
		return personalausweisId;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

}
