package de.dhbw.kontoverwaltung.terminal.process.konto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class ChangeBankKontoCommand extends CommandParser {

	private KontoEvents kontoEvents;

	public ChangeBankKontoCommand(KontoEvents kontoEvents) {
		super();
		this.kontoEvents = kontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 4) {
			String kontoId = command.getStringAt(2);
			String newBank = command.getStringAt(3);
			return kontoEvents.changeBank(kontoId, newBank);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("old-kontoid", "new-bank"));
	}
}
