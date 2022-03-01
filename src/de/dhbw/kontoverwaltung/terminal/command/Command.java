package de.dhbw.kontoverwaltung.terminal.command;

public interface Command {
	
	public CommandResult execute(String[] inputSplit);
	
}
