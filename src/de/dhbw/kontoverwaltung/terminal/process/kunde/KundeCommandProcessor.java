package de.dhbw.kontoverwaltung.terminal.process.kunde;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class KundeCommandProcessor extends UppercaseCommandParser {

	public KundeCommandProcessor(KundeEvents kundeEvents) {
		super(1);
		commands.put("CREATE", new CreateKundeCommand(kundeEvents));
		// TODO
	}

	
}
