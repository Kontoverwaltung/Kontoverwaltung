package de.dhbw.kontoverwaltung.terminal.process.geldausgabeautomat;

import de.dhbw.kontoverwaltung.events.geldausgabeautomat.GeldAusgabeAutomatEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class GeldAusgabeAutomatCommandProcessor extends UppercaseCommandParser {

	public GeldAusgabeAutomatCommandProcessor(GeldAusgabeAutomatEvents geldAusgabeAutomatEvents) {
		super(1);
		commands.put("GET", new GetGeldAusgabeAutomatCommand(geldAusgabeAutomatEvents));
		commands.put("CREATE", new CreateGeldAusgabeAutomatCommand(geldAusgabeAutomatEvents));
		commands.put("DELETE", new DeleteGeldAusgabeAutomatCommand(geldAusgabeAutomatEvents));
	}

}
