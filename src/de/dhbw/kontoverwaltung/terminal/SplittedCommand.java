package de.dhbw.kontoverwaltung.terminal;

public class SplittedCommand {

	private String[] splittedCommand;

	public SplittedCommand(String command, String seperator) {
		super();
		this.splittedCommand = command.split(seperator);
	}
	
	public String getStringAt(int pos) {
		if(splittedCommand.length > pos) {
			return splittedCommand[pos];
		} else {
			return null;
		}
	}
	
	public String getStringUppercaseAt(int pos) {
		return getStringAt(pos).toUpperCase();
	}

	public int getIntAt(int pos) throws NumberFormatException {
		return Integer.valueOf(getStringAt(pos));
	}
	
	public int argsSize() {
		return splittedCommand.length;
	}

}
