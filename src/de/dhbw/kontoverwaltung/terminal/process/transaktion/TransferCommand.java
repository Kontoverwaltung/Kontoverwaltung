package de.dhbw.kontoverwaltung.terminal.process.transaktion;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class TransferCommand extends CommandParser {

	private TransaktionEvents transaktionEvents;

	public TransferCommand(TransaktionEvents transaktionEvents) {
		super();
		this.transaktionEvents = transaktionEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 5) {
			String from = command.getStringAt(2);
			String to = command.getStringAt(3);
			String betrag = command.getStringAt(4);
			return transaktionEvents.transfer(from, to, betrag);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("from", "to", "betrag"));
	}
}
