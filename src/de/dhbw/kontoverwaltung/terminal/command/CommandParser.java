package de.dhbw.kontoverwaltung.terminal.command;

import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public abstract class CommandParser {

	public CommandParser() {
		super();
	}

	public abstract CommandResult execute(SplittedCommand command);

}
