package de.dhbw.kontoverwaltung.terminal.command;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.process.kunde.KundeProcessor;

public class CommandParser implements CommandListener {

	private Map<String, Command> commandGroups = new HashMap<>();

	public CommandParser(KundeEvents kundeEvents) {
		super();
		commandGroups.put("KUNDE", new KundeProcessor(kundeEvents));
	}

	@Override
	public CommandResult onInput(String input) {
		String[] inputSplit = input.split(" ");
		String commandGroup = inputSplit[0].toUpperCase();

		Command command = commandGroups.get(commandGroup);
		if (command != null) {
			return command.execute(inputSplit);
		}
		return CommandResult.commandNotFound();

	}
}
