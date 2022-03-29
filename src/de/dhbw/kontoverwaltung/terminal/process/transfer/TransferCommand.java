package de.dhbw.kontoverwaltung.terminal.process.transfer;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.transfer.TransferEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class TransferCommand extends CommandParser {

	private TransferEvents transferEvents;

	public TransferCommand(TransferEvents transferEvents) {
		super();
		this.transferEvents = transferEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 4) {
			String from = command.getStringAt(1);
			String to = command.getStringAt(2);
			String betrag = command.getStringAt(3);
			return transferEvents.transfer(from, to, betrag);
		}
		return CommandResult.usage(command.getCommandUpToPos(1), Arrays.asList("from", "to", "betrag"));
	}
}
