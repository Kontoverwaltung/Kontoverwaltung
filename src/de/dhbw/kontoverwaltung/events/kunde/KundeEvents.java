package de.dhbw.kontoverwaltung.events.kunde;

import de.dhbw.kontoverwaltung.terminal.CommandResult;

public interface KundeEvents {

	public CommandResult createNewKunde(String bankName, String vorname, String nachname);

}
