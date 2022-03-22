package de.dhbw.kontoverwaltung.terminal.process.konto;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateKontoCommand extends CommandParser {

	private KontoEvents kontoEvents;

	public CreateKontoCommand(KontoEvents kontoEvents) {
		super();
		this.kontoEvents = kontoEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 5) {
			String bankName = command.getStringAt(2);
			String kundenId = command.getStringAt(3);
			String pin = command.getStringAt(4);
			return kontoEvents.createNewKonto(bankName, kundenId, pin);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("bankname", "kundenid", "pin"));
	}
}
