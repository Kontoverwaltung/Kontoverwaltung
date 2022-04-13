package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.GiroKonto;

public class GiroKontoReturn extends Return {

	private GiroKonto instance;

	public GiroKontoReturn(boolean successful, GiroKonto instance) {
		super(successful);
		this.instance = instance;
	}

	public GiroKonto getInstance() {
		return instance;
	}
}
