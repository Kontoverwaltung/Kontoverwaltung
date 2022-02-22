package de.dhbw.kontoverwaltung.repositories.returns;

import de.dhbw.kontoverwaltung.types.personen.Kunde;

public class KundeReturn {
	
	private boolean successful;
	private Kunde kunde;
	
	public KundeReturn(boolean successful, Kunde kunde) {
		super();
		this.successful = successful;
		this.kunde = kunde;
	}
	
	public boolean isSuccessful() {
		return successful;
	}
	public Kunde getKunde() {
		return kunde;
	}
}
