package de.dhbw.kontoverwaltung.terminal.process.kunde;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.command.Command;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class KundeProcessor implements Command {

	private Map<String, Command> commands = new HashMap<>();

	public KundeProcessor(KundeEvents kundeEvents) {
		super();
		commands.put("CREATE", new CreateKunde(kundeEvents));

	}

	@Override
	public CommandResult execute(String[] inputSplit) {
		if (commands.get(inputSplit[1].toUpperCase()) != null) {
			return commands.get(inputSplit[1].toUpperCase()).execute(inputSplit);
		}
		return CommandResult.commandNotFound();
	}
}
