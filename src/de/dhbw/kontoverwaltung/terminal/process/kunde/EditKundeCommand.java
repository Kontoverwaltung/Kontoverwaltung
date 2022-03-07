package de.dhbw.kontoverwaltung.terminal.process.kunde;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class EditKundeCommand extends CommandParser {

	private KundeEvents kundeEvents;

	public EditKundeCommand(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 6) {
			String oldKundenId = command.getStringAt(2);
			String newBankName = command.getStringAt(3);
			String newVorname = command.getStringAt(4);
			String newNachname = command.getStringAt(5);
			return kundeEvents.editKunde(oldKundenId, newBankName, newVorname, newNachname);
		}
		return CommandResult.commandNotFound();
	}
}
