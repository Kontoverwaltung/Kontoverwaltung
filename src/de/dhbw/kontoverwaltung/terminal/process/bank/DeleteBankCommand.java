package de.dhbw.kontoverwaltung.terminal.process.bank;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class DeleteBankCommand extends CommandParser {

	private static final int COMMAND_HELP_CUT = 2;
	private static final int ARG_BANK = 2;
	private static final int EXPECTED_LENGTH = 3;
	
	private BankEvents bankEvents;

	public DeleteBankCommand(BankEvents bankEvents) {
		super();
		this.bankEvents = bankEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == EXPECTED_LENGTH) {
			String bankName = command.getStringAt(ARG_BANK);
			return bankEvents.deleteBank(bankName);
		}
		return CommandResult.usage(command.getCommandUpToPos(COMMAND_HELP_CUT), Arrays.asList("bankname"));
	}

}
