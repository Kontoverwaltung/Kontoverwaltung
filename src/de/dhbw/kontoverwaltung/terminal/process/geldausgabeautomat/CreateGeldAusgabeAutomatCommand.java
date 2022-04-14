package de.dhbw.kontoverwaltung.terminal.process.geldausgabeautomat;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateGeldAusgabeAutomatCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_AUTOMAT = 2;
	private static final int ARG_BETRAG = 3;
	private static final int EXPECTED_LENGTH = 4;

	private GeldAusgabeAutomatEvents ausgabeAutomatEvents;

	public CreateGeldAusgabeAutomatCommand(GeldAusgabeAutomatEvents ausgabeAutomatEvents) {
		super();
		this.ausgabeAutomatEvents = ausgabeAutomatEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String automatId = command.getStringAt(ARG_AUTOMAT);
			String betrag = command.getStringAt(ARG_BETRAG);
			return ausgabeAutomatEvents.createGeldAusgabeAutomat(automatId, betrag);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("automat-id", "betrag"));
	}

}
