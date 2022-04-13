package de.dhbw.kontoverwaltung.terminal.process.kunde;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class GetKundeCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_KUNDE = 2;
	private static final int EXPECTED_LENGTH = 3;
	
	private KundeEvents kundeEvents;

	public GetKundeCommand(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String kundenId = command.getStringAt(ARG_KUNDE);
			return kundeEvents.getKunde(kundenId);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("kundenid"));
	}
}
