package de.dhbw.kontoverwaltung.terminal;

public class CommandResult {

	private boolean successful;
	private String additionalInfo;

	private CommandResult(boolean successful, String additionalInfo) {
		super();
		this.successful = successful;
		this.additionalInfo = additionalInfo;
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (successful) {
			stringBuilder.append("OK");
		} else {
			stringBuilder.append("ERROR");
		}
		stringBuilder.append(": ");
		stringBuilder.append(additionalInfo);

		return stringBuilder.toString();
	}

}