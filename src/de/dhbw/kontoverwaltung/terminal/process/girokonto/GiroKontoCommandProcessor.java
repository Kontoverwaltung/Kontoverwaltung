package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class GiroKontoCommandProcessor extends UppercaseCommandParser {

	private static final int HIERARCHY_LEVEL = 1;
	
	public GiroKontoCommandProcessor(GiroKontoEvents kontoEvents) {
		super(HIERARCHY_LEVEL);
		commands.put("GET", new GetGiroKontoCommand(kontoEvents));
		commands.put("CREATE", new CreateGiroKontoCommand(kontoEvents));
		commands.put("DELETE", new DeleteGiroKontoCommand(kontoEvents));
		commands.put("CHANGEPIN", new ChangePinGiroKontoCommand(kontoEvents));
		commands.put("CHANGEBANK", new ChangeBankGiroKontoCommand(kontoEvents));
		commands.put("GETHISTORY", new GetHistoryGiroKontoCommand(kontoEvents));
	}

}
