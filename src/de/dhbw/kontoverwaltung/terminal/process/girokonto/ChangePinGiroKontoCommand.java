package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class ChangePinGiroKontoCommand extends CommandParser {

	private GiroKontoEvents giroKontoEvents;

	public ChangePinGiroKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 5) {
			String giroKontoId = command.getStringAt(2);
			String oldPin = command.getStringAt(3);
			String newPin = command.getStringAt(4);
			return giroKontoEvents.changePin(giroKontoId, oldPin, newPin);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("girokontoid", "old-pin", "new-pin"));
	}
}
