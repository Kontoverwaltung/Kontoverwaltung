package de.dhbw.kontoverwaltung.terminal.command;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.kontoverwaltung.terminal.SplittedCommand;

public abstract class UppercaseCommandParser extends CommandParser {

	private int position;
	protected Map<String, CommandParser> commands = new HashMap<>();

	public UppercaseCommandParser(int switchPos) {
		super();
		this.position = switchPos;
	}

	public CommandResult execute(SplittedCommand command) {
		CommandParser commandParser = commands.get(command.getStringUppercaseAt(position));
		if (commandParser != null) {
			return commandParser.execute(command);
		}
		return CommandResult.commandNotFound();
	}

}
