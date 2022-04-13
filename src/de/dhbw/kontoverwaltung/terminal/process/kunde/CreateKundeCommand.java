package de.dhbw.kontoverwaltung.terminal.process.kunde;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateKundeCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_VORNAME = 2;
	private static final int ARG_NACHNAME = 3;
	private static final int EXPECTED_LENGTH = 4;
	
	private KundeEvents kundeEvents;

	public CreateKundeCommand(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String vorname = command.getStringAt(ARG_VORNAME);
			String nachname = command.getStringAt(ARG_NACHNAME);
			return kundeEvents.createNewKunde(vorname, nachname);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("vorname", "nachname"));
	}
}
