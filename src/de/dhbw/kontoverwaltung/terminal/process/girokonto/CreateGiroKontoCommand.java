package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateGiroKontoCommand extends CommandParser {

	private GiroKontoEvents giroKontoEvents;

	public CreateGiroKontoCommand(GiroKontoEvents giroKontoEvents) {
		super();
		this.giroKontoEvents = giroKontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 5) {
			String bankName = command.getStringAt(2);
			String kundenId = command.getStringAt(3);
			String pin = command.getStringAt(4);
			return giroKontoEvents.createNewGiroKonto(bankName, kundenId, pin);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("bankname", "kundenid", "pin"));
	}
}
