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
		if (command.argsSize() == 4) {
			String konto = command.getStringAt(2);
			String betrag = command.getStringAt(3);
			return transaktionEvents.cashOut(konto, betrag);
		}
		return CommandResult.usage(command.getCommandUpToPos(1), Arrays.asList("konto", "betrag"));
	}
}
