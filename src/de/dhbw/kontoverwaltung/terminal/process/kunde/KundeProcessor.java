package de.dhbw.kontoverwaltung.terminal.process.kunde;

import java.util.HashMap;
import java.util.Map;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class KundeProcessor extends CommandParser {

	private Map<String, CommandParser> commands = new HashMap<>();

	public KundeProcessor(KundeEvents kundeEvents) {
		super();
		commands.put("CREATE", new CreateKunde(kundeEvents));
		// TODO
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		CommandParser commandParser = commands.get(command.getStringUppercaseAt(1));
		if (commandParser != null) {
			return commandParser.execute(command);
		}
		return CommandResult.commandNotFound();
	}
}
