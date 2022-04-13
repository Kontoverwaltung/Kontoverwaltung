package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class ChangeBankGiroKontoCommand extends CommandParser {

	private GiroKontoEvents giroKontoEvents;

	public ChangeBankGiroKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 4) {
			String giroKontoId = command.getStringAt(2);
			String newBank = command.getStringAt(3);
			return giroKontoEvents.changeBank(giroKontoId, newBank);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("old-girokontoid", "new-bank"));
	}
}
