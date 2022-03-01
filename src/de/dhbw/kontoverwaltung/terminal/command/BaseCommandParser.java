package de.dhbw.kontoverwaltung.terminal.command;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.process.kunde.KundeProcessor;

public class BaseCommandParser extends CommandParser {

	private Map<String, CommandParser> commandGroups = new HashMap<>();

	public BaseCommandParser(KundeEvents kundeEvents) {
		super();
		commandGroups.put("KUNDE", new KundeProcessor(kundeEvents));
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		CommandParser commandParser = commandGroups.get(command.getStringUppercaseAt(0));
		if (commandParser != null) {
			return commandParser.execute(command);
		}
		return CommandResult.commandNotFound();
	}

}
