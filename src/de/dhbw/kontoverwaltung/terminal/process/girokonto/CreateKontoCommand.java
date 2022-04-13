package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateKontoCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_BANK = 2;
	private static final int ARG_KUNDE = 3;
	private static final int ARG_PIN = 4;
	private static final int EXPECTED_LENGTH = 5;

	private GiroKontoEvents giroKontoEvents;

	public CreateKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String bankName = command.getStringAt(ARG_BANK);
			String kundenId = command.getStringAt(ARG_KUNDE);
			String pin = command.getStringAt(ARG_PIN);
			return giroKontoEvents.createNewGiroKonto(bankName, kundenId, pin);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("bankname", "kundenid", "pin"));
	}
}
