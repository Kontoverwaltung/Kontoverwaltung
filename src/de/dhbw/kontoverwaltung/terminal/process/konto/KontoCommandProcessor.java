package de.dhbw.kontoverwaltung.terminal.process.konto;

import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class KontoCommandProcessor extends UppercaseCommandParser {

	public KontoCommandProcessor(KontoEvents kontoEvents) {
		super(1);
		commands.put("GET", new GetKontoCommand(kontoEvents));
		commands.put("CREATE", new CreateKontoCommand(kontoEvents));
		commands.put("DELETE", new DeleteKontoCommand(kontoEvents));
		commands.put("CHANGEPIN", new ChangePinKontoCommand(kontoEvents));
		commands.put("CHANGEBANK", new ChangeBankKontoCommand(kontoEvents));
	}

}
