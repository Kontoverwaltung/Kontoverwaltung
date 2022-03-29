package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;

public class AutomatReturn extends Return {

	private GeldAusgabeAutomat instance;

	public AutomatReturn(boolean successful, GeldAusgabeAutomat instance) {
		super(successful);
		this.instance = instance;
	}

	public GeldAusgabeAutomat getInstance() {
		return instance;
	}
}
