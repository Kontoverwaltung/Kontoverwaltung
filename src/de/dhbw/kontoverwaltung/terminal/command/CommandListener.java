package de.dhbw.kontoverwaltung.terminal.command;

public interface CommandListener {

	public CommandResult onInput(String input);

}
