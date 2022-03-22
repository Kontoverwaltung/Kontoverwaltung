package de.dhbw.kontoverwaltung.terminal.process.konto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class ChangePinKontoCommand extends CommandParser {

	private KontoEvents kontoEvents;

	public ChangePinKontoCommand(KontoEvents kontoEvents) {
		super();
		this.kontoEvents = kontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 5) {
			String kontoId = command.getStringAt(2);
			String oldPin = command.getStringAt(3);
			String newPin = command.getStringAt(4);
			return kontoEvents.changePin(kontoId, oldPin, newPin);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("kontoid", "old-pin", "new-pin"));
	}
}
