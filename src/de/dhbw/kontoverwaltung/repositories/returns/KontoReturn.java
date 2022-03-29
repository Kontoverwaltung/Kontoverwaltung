package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.GiroKonto;

public class KontoReturn extends Return {

	private GiroKonto instance;

	public KontoReturn(boolean successful, GiroKonto instance) {
		super(successful);
		this.instance = instance;
	}

	public GiroKonto getInstance() {
		return instance;
	}
}
