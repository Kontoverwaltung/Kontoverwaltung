package de.dhbw.kontoverwaltung.terminal.process.transaktion;

import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class TransaktionCommandProcessor extends UppercaseCommandParser {

	public TransaktionCommandProcessor(TransaktionEvents transaktionEvents) {
		super(1);
		commands.put("TRANSFER", new TransaktionCommand(transaktionEvents));
		commands.put("CASH_IN", new CashInCommand(transaktionEvents));
		commands.put("CASH_OUT", new CashOutCommand(transaktionEvents));
	}

}
