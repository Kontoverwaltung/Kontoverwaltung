package de.dhbw.kontoverwaltung.events.kunde;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface KundeEvents {

	public CommandResult getKunde(String kundenId);

	public CommandResult createNewKunde(String bankName, String vorname, String nachname);

	public CommandResult deleteKunde(String kundenId);

}
