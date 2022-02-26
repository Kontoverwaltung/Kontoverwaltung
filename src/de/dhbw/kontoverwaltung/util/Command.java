package de.dhbw.kontoverwaltung.util;

import de.dhbw.kontoverwaltung.terminal.CommandResult;

public interface Command {
	CommandResult execute(String[] inputSplit);
}
