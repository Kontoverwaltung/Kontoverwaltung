package de.dhbw.kontoverwaltung.terminal.process.kunde;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateKundeCommand extends CommandParser {

	private KundeEvents kundeEvents;

	public CreateKundeCommand(KundeEvents kundeEvents) {
		super();
		this.kundeEvents = kundeEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 5) {
			String bankName = command.getStringAt(2);
			String vorname = command.getStringAt(3);
			String nachname = command.getStringAt(4);
			return kundeEvents.createNewKunde(bankName, vorname, nachname);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("bankname", "vorname", "nachname"));
	}
}
