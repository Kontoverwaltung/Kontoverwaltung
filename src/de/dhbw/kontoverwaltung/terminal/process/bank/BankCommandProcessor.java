package de.dhbw.kontoverwaltung.terminal.process.bank;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class BankCommandProcessor extends UppercaseCommandParser {

	private static final int HIERARCHY_LEVEL = 1;
	
	public BankCommandProcessor(BankEvents bankEvents) {
		super(HIERARCHY_LEVEL);
		commands.put("GET", new GetBankCommand(bankEvents));
		commands.put("CREATE", new CreateBankCommand(bankEvents));
		commands.put("DELETE", new DeleteBankCommand(bankEvents));
	}

}
