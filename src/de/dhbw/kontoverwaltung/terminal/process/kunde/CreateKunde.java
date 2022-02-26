package de.dhbw.kontoverwaltung.terminal.process.kunde;

import de.dhbw.kontoverwaltung.events.kunde.KundeEventsImpl;
import de.dhbw.kontoverwaltung.terminal.CommandResult;
import de.dhbw.kontoverwaltung.util.Command;

public class CreateKunde implements Command {
	KundeEventsImpl kundeEvents = new KundeEventsImpl();

	@Override
	public CommandResult execute(String[] inputSplit) {
		if (inputSplit.length == 5) {
			String bankName = inputSplit[2];
			String vorname = inputSplit[3];
			String nachname = inputSplit[4];
			return kundeEvents.createNewKunde(bankName, vorname, nachname);
		}
		return CommandResult.error("command not found");
	}
}
