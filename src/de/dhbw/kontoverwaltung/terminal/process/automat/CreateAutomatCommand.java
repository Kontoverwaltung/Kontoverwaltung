package de.dhbw.kontoverwaltung.terminal.process.automat;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.automat.AutomatEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CreateAutomatCommand extends CommandParser {

	private AutomatEvents automatEvents;

	public CreateAutomatCommand(AutomatEvents automatEvents) {
		super();
		this.automatEvents = automatEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 4) {
			String automatId = command.getStringAt(2);
			String betrag = command.getStringAt(3);
			return automatEvents.createAutomat(automatId, betrag);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("automat-id", "betrag"));
	}

}
