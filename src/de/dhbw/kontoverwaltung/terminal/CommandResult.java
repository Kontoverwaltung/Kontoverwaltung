package de.dhbw.kontoverwaltung.terminal;

public class CommandResult {

	private boolean successful;
	private String additionalInfo;

	private CommandResult(boolean successful, String additionalInfo) {
		super();
		this.successful = successful;
		this.additionalInfo = additionalInfo;
	}

	public static CommandResult of(boolean successful, String additionalInfo) {
		return new CommandResult(successful, additionalInfo);
	}

	public static CommandResult success(String additionalInfo) {
		return new CommandResult(true, additionalInfo);
	}

	public static CommandResult error(String additionalInfo) {
		return new CommandResult(false, additionalInfo);
	}

	public boolean isSuccessful() {
		return successful;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public static CommandResult okay() {
		return success("OK");
	}

}
