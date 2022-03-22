package de.dhbw.kontoverwaltung.terminal.process.konto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class GetKontoCommand extends CommandParser {

	private KontoEvents kontoEvents;

	public GetKontoCommand(KontoEvents kontoEvents) {
		super();
		this.kontoEvents = kontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String kontoId = command.getStringAt(2);
			return kontoEvents.getKonto(kontoId);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("kontoid"));
	}
}
