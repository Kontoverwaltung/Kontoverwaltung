package de.dhbw.kontoverwaltung.types;

import java.io.Serializable;

import de.dhbw.kontoverwaltung.util.UniqueIdGenerator;

public class Person implements Serializable {

	protected String vorname;
	protected String nachname;

	private String kundenId;

	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.kundenId = UniqueIdGenerator.next();
	}

	public String getKundenId() {
		return kundenId;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	@Override
	public String toString() {
		return "Kunde [KundenID=" + kundenId + "]";
	}

}
