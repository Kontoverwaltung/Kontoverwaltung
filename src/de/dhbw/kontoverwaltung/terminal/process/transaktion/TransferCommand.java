package de.dhbw.kontoverwaltung.terminal.process.transaktion;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.transaktion.TransaktionEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class TransferCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_FROM = 2;
	private static final int ARG_TO = 3;
	private static final int ARG_BETRAG = 4;
	private static final int EXPECTED_LENGTH = 5;

	private TransaktionEvents transaktionEvents;

	public TransferCommand(TransaktionEvents transaktionEvents) {
		super();
		this.transaktionEvents = transaktionEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String from = command.getStringAt(ARG_FROM);
			String to = command.getStringAt(ARG_TO);
			String betrag = command.getStringAt(ARG_BETRAG);
			return transaktionEvents.transfer(from, to, betrag);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("from", "to", "betrag"));
	}
}
