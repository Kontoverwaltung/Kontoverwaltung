package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.Person;

public class KundeReturn extends Return {

	private Person instance;

	public KundeReturn(boolean successful, Person instance) {
		super(successful);
		this.instance = instance;
	}

	public Person getInstance() {
		return instance;
	}
}
