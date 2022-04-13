package de.dhbw.kontoverwaltung.terminal.process.automat;

import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class GeldAusgabeAutomatCommandProcessor extends UppercaseCommandParser {

	private static final int HIERARCHY_LEVEL = 1;

	public GeldAusgabeAutomatCommandProcessor(GeldAusgabeAutomatEvents ausgabeAutomatEvents) {
		super(HIERARCHY_LEVEL);
		commands.put("GET", new GetAutomatCommand(ausgabeAutomatEvents));
		commands.put("CREATE", new CreateAutomatCommand(ausgabeAutomatEvents));
		commands.put("DELETE", new DeleteAutomatCommand(ausgabeAutomatEvents));
	}

}
