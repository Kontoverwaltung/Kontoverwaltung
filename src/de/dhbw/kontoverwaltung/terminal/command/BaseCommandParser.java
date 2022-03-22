package de.dhbw.kontoverwaltung.terminal.command;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.process.bank.BankCommandProcessor;
import de.dhbw.kontoverwaltung.terminal.process.konto.KontoCommandProcessor;
import de.dhbw.kontoverwaltung.terminal.process.kunde.KundeCommandProcessor;

public class BaseCommandParser extends UppercaseCommandParser {

	public BaseCommandParser(KundeEvents kundeEvents, BankEvents bankEvents, KontoEvents kontoEvents) {
		super(0);
		commands.put("KUNDE", new KundeCommandProcessor(kundeEvents));
		commands.put("BANK", new BankCommandProcessor(bankEvents));
		commands.put("KONTO", new KontoCommandProcessor(kontoEvents));
	}

}
