package de.dhbw.kontoverwaltung.terminal.command.results;

public class ObjectToStringCommandResult extends CommandResult {

	public ObjectToStringCommandResult(Object Object) {
		super(true, createInfo(Object));
	}

	private static String createInfo(Object object) {
		return object.toString();
	}

}
