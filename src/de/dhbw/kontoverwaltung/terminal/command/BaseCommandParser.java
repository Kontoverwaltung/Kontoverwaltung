package de.dhbw.kontoverwaltung.terminal.command;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.terminal.process.bank.BankCommandProcessor;
import de.dhbw.kontoverwaltung.terminal.process.kunde.KundeCommandProcessor;

public class BaseCommandParser extends UppercaseCommandParser {

	public BaseCommandParser(KundeEvents kundeEvents, BankEvents bankEvents) {
		super(0);
		commands.put("KUNDE", new KundeCommandProcessor(kundeEvents));
		commands.put("BANK", new BankCommandProcessor(bankEvents));
	}

}
