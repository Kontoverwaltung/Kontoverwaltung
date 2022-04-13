package de.dhbw.kontoverwaltung.terminal.process.kunde;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class KundeCommandProcessor extends UppercaseCommandParser {

	private static final int HIERARCHY_LEVEL = 1;

	public KundeCommandProcessor(KundeEvents kundeEvents) {
		super(HIERARCHY_LEVEL);
		commands.put("GET", new GetKundeCommand(kundeEvents));
		commands.put("CREATE", new CreateKundeCommand(kundeEvents));
		commands.put("DELETE", new DeleteKundeCommand(kundeEvents));
	}

}
