package de.dhbw.kontoverwaltung.terminal.process.transaktion;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class CashOutCommand extends CommandParser {

	private TransaktionEvents transaktionEvents;

	public CashOutCommand(TransaktionEvents transaktionEvents) {
		super();
		this.transaktionEvents = transaktionEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 6) {
			String automat = command.getStringAt(2);
			String konto = command.getStringAt(3);
			String betrag = command.getStringAt(4);
			String pin = command.getStringAt(5);
			return transaktionEvents.cashOut(automat, konto, betrag, pin);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("automat", "konto", "betrag", "pin"));
	}
}
