package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class ChangePinGiroKontoCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_KONTO = 2;
	private static final int ARG_PIN_OLD = 3;
	private static final int ARG_PIN_NEW = 4;
	private static final int EXPECTED_LENGTH = 5;

	private GiroKontoEvents giroKontoEvents;

	public ChangePinGiroKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String kontoId = command.getStringAt(ARG_KONTO);
			String oldPin = command.getStringAt(ARG_PIN_OLD);
			String newPin = command.getStringAt(ARG_PIN_NEW);
			return giroKontoEvents.changePin(kontoId, oldPin, newPin);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("kontoid", "old-pin", "new-pin"));
	}
}
