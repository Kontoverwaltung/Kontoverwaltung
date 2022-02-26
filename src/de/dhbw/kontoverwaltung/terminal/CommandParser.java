package de.dhbw.kontoverwaltung.terminal;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.process.kunde.KundeProcessor;
import de.dhbw.kontoverwaltung.util.Command;

public class CommandParser implements CommandListener {
	Map<String, Command> commandGroups = new HashMap<>();

	public CommandParser() {
		super();
		commandGroups.put("KUNDE", new KundeProcessor());
	}

	@Override
	public CommandResult onInput(String input) {
		String[] inputSplit = input.split(" ");

		if (commandGroups.get(inputSplit[0].toUpperCase()) != null) {
			return commandGroups.get(inputSplit[0].toUpperCase()).execute(inputSplit);
		}
		return CommandResult.error("command not found");

	}
}
