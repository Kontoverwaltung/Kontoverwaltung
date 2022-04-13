package de.dhbw.kontoverwaltung.terminal.process.konto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class ChangeBankKontoCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_KONTO_ID = 2;
	private static final int ARG_BANK = 3;
	private static final int EXPECTED_LENGTH = 4;

	private GiroKontoEvents giroKontoEvents;

	public ChangeBankKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String kontoId = command.getStringAt(ARG_KONTO_ID);
			String newBank = command.getStringAt(ARG_BANK);
			return giroKontoEvents.changeBank(kontoId, newBank);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("old-kontoid", "new-bank"));
	}
}
