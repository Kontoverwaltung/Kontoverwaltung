package de.dhbw.kontoverwaltung.terminal.process.automat;

import de.dhbw.kontoverwaltung.events.automat.AutomatEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class AutomatCommandProcessor extends UppercaseCommandParser {

	public AutomatCommandProcessor(AutomatEvents automatEvents) {
		super(1);
		commands.put("GET", new GetAutomatCommand(automatEvents));
		commands.put("CREATE", new CreateAutomatCommand(automatEvents));
		commands.put("DELETE", new DeleteAutomatCommand(automatEvents));
	}

}
