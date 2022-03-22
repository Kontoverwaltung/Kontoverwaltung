package de.dhbw.kontoverwaltung.terminal.process.kunde;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class KundeCommandProcessor extends UppercaseCommandParser {

	public KundeCommandProcessor(KundeEvents kundeEvents) {
		super(1);
		commands.put("GET", new GetKundeCommand(kundeEvents));
		commands.put("CREATE", new CreateKundeCommand(kundeEvents));
		commands.put("EDIT", new EditKundeCommand(kundeEvents));
		commands.put("DELETE", new DeleteKundeCommand(kundeEvents));
	}

}
