package de.dhbw.kontoverwaltung.terminal.process.automat;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class DeleteAutomatCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_AUTOMAT = 2;
	private static final int EXPECTED_LENGTH = 3;
	
	private GeldAusgabeAutomatEvents ausgabeAutomatEvents;

	public DeleteAutomatCommand(GeldAusgabeAutomatEvents ausgabeAutomatEvents) {
		super();
		this.ausgabeAutomatEvents = ausgabeAutomatEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String automatId = command.getStringAt(ARG_AUTOMAT);
			return ausgabeAutomatEvents.deleteGeldAusgabeAutomat(automatId);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("automat-id"));
	}

}
