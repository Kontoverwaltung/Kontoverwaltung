package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.personen.Kunde;

public abstract class Return {
	private boolean successful;
	private Object instance;
	
	public Return(boolean successful, Kunde instance) {
		super();
		this.successful = successful;
		this.instance = instance;
	}
	
	public boolean isSuccessful() {
		return successful;
	}
	
	public Object getInstance() {
		return instance;
	}
}
