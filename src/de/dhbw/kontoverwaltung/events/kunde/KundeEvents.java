package de.dhbw.kontoverwaltung.events.kunde;

import de.dhbw.kontoverwaltung.terminal.CommandResult;

public interface KundeEvents {

	public CommandResult getKunde(String kundenId);
	public CommandResult createNewKunde(String bankName, String vorname, String nachname);
	public CommandResult editKunde(String oldKundenId, String newBankName, String newVorname, String newNachname);
	public CommandResult deleteKunde(String kundenId);

}
