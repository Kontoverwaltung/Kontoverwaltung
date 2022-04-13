package de.dhbw.kontoverwaltung.terminal.process.konto;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class GiroKontoCommandProcessor extends UppercaseCommandParser {

	private static final int HIERARCHY_LEVEL = 1;
	
	public GiroKontoCommandProcessor(GiroKontoEvents kontoEvents) {
		super(HIERARCHY_LEVEL);
		commands.put("GET", new GetKontoCommand(kontoEvents));
		commands.put("CREATE", new CreateKontoCommand(kontoEvents));
		commands.put("DELETE", new DeleteKontoCommand(kontoEvents));
		commands.put("CHANGEPIN", new ChangePinKontoCommand(kontoEvents));
		commands.put("CHANGEBANK", new ChangeBankKontoCommand(kontoEvents));
		commands.put("GETHISTORY", new GetHistoryKontoCommand(kontoEvents));
	}

}
