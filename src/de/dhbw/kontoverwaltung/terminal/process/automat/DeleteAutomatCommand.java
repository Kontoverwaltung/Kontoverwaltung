package de.dhbw.kontoverwaltung.terminal.process.automat;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.automat.AutomatEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class DeleteAutomatCommand extends CommandParser {

	private AutomatEvents automatEvents;

	public DeleteAutomatCommand(AutomatEvents automatEvents) {
		super();
		this.automatEvents = automatEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String automatId = command.getStringAt(2);
			return automatEvents.deleteAutomat(automatId);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("automat-id"));
	}

}
