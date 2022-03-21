package de.dhbw.kontoverwaltung.terminal.process.kunde;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class DeleteKundeCommand extends CommandParser {

	private KundeEvents kundeEvents;

	public DeleteKundeCommand(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String kundenId = command.getStringAt(2);
			return kundeEvents.deleteKunde(kundenId);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("kundenid"));
	}
}
