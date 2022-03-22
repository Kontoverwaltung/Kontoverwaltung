package de.dhbw.kontoverwaltung.terminal.process.bank;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class BankCommandProcessor extends UppercaseCommandParser {

	public BankCommandProcessor(BankEvents bankEvents) {
		super(1);
		commands.put("GET", new GetBankCommand(bankEvents));
		commands.put("CREATE", new CreateBankCommand(bankEvents));
		commands.put("DELETE", new DeleteBankCommand(bankEvents));
	}

}
