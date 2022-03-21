package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.Konto;

public class KontoReturn extends Return {

	private Konto instance;

	public KontoReturn(boolean successful, Konto instance) {
		super(successful);
		this.instance = instance;
	}

	public Konto getInstance() {
		return instance;
	}
}
