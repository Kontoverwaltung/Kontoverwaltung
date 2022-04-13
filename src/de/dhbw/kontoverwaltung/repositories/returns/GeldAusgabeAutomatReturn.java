package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;

public class GeldAusgabeAutomatReturn extends Return {

	private GeldAusgabeAutomat instance;

	public GeldAusgabeAutomatReturn(boolean successful, GeldAusgabeAutomat instance) {
		super(successful);
		this.instance = instance;
	}

	public GeldAusgabeAutomat getInstance() {
		return instance;
	}
}
