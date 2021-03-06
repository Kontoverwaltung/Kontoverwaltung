package de.dhbw.kontoverwaltung.terminal.process.transaktion;

import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEvents;
import de.dhbw.kontoverwaltung.terminal.command.UppercaseCommandParser;

public class TransaktionCommandProcessor extends UppercaseCommandParser {

	private static final int HIERARCHY_LEVEL = 1;

	public TransaktionCommandProcessor(TransaktionEvents transaktionEvents) {
		super(HIERARCHY_LEVEL);
		commands.put("TRANSFER", new TransferCommand(transaktionEvents));
		commands.put("CASH_IN", new CashInCommand(transaktionEvents));
		commands.put("CASH_OUT", new CashOutCommand(transaktionEvents));
	}

}
