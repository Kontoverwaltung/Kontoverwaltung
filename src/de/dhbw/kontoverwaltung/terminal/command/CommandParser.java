package de.dhbw.kontoverwaltung.terminal.command;

import de.dhbw.kontoverwaltung.terminal.SplittedCommand;

public abstract class CommandParser {

	public CommandParser() {
		super();
	}

	public abstract CommandResult execute(SplittedCommand command);

}
