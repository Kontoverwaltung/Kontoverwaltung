package de.dhbw.kontoverwaltung.terminal.process.kunde;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class GetKundeCommand extends CommandParser {

	private KundeEvents kundeEvents;

	public GetKundeCommand(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String kundenId = command.getStringAt(2);
			return kundeEvents.getKunde(kundenId);
		}
		return CommandResult.commandNotFound();
	}
}
