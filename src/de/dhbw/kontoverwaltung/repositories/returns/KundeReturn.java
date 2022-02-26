package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.personen.Kunde;

public class KundeReturn extends Return {
	private Kunde instance;
	
	public KundeReturn(boolean successful, Kunde instance) {
		super(successful, instance);
	}

	@Override
	public Kunde getInstance() {
		return instance;
	}
}
