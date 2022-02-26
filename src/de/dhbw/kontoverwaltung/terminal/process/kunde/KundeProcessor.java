package de.dhbw.kontoverwaltung.terminal.process.kunde;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.kontoverwaltung.terminal.CommandResult;
import de.dhbw.kontoverwaltung.util.Command;

public class KundeProcessor implements Command {
	private Map<String, Command> commands = new HashMap<>();
	
	public KundeProcessor() {
		super();
		commands.put("CREATE", new CreateKunde());
		
	}
	
	@Override
	public CommandResult execute(String[] inputSplit) {
		if(commands.get(inputSplit[1].toUpperCase()) != null) {
			return commands.get(inputSplit[1].toUpperCase()).execute(inputSplit);
		}
		return CommandResult.error("command not found");
	}
}
