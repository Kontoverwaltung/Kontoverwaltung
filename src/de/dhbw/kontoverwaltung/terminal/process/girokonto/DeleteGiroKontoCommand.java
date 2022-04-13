package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class DeleteGiroKontoCommand extends CommandParser {

	private GiroKontoEvents giroKontoEvents;

	public DeleteGiroKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String giroKontoId = command.getStringAt(2);
			return giroKontoEvents.deleteGiroKonto(giroKontoId);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("girokontoid"));
	}
}
