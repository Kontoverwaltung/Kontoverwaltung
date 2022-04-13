package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class DeleteKontoCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_KONTO = 2;
	private static final int EXPECTED_LENGTH = 3;

	private GiroKontoEvents giroKontoEvents;

	public DeleteKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String kontoId = command.getStringAt(ARG_KONTO);
			return giroKontoEvents.deleteGiroKonto(kontoId);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("kontoid"));
	}
}
