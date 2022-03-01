package de.dhbw.kontoverwaltung.terminal.process.kunde;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.command.Command;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class CreateKunde implements Command {
	
	private KundeEvents kundeEvents;

	public CreateKunde(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult execute(String[] inputSplit) {
		if (inputSplit.length == 5) {
			String bankName = inputSplit[2];
			String vorname = inputSplit[3];
			String nachname = inputSplit[4];
			return kundeEvents.createNewKunde(bankName, vorname, nachname);
		}
		return CommandResult.commandNotFound();
	}
}
