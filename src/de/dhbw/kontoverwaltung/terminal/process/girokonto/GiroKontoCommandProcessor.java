package de.dhbw.kontoverwaltung.terminal.process.girokonto;

import de.dhbw.kontoverwaltung.events.girokonto.GiroKontoEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class GiroKontoCommandProcessor extends UppercaseCommandParser {

	public GiroKontoCommandProcessor(GiroKontoEvents giroKontoEvents) {
		super(1);
		commands.put("GET", new GetGiroKontoCommand(giroKontoEvents));
		commands.put("CREATE", new CreateGiroKontoCommand(giroKontoEvents));
		commands.put("DELETE", new DeleteGiroKontoCommand(giroKontoEvents));
		commands.put("CHANGEPIN", new ChangePinGiroKontoCommand(giroKontoEvents));
		commands.put("CHANGEBANK", new ChangeBankGiroKontoCommand(giroKontoEvents));
		commands.put("GETHISTORY", new GetHistoryGiroKontoCommand(giroKontoEvents));
	}

}
