package de.dhbw.kontoverwaltung.terminal.process.bank;

import java.util.Arrays;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public class DeleteBankCommand extends CommandParser {

	private BankEvents bankEvents;

	public DeleteBankCommand(BankEvents bankEvents) {
		super();
		this.bankEvents = bankEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String bankName = command.getStringAt(2);
			return bankEvents.deleteBank(bankName);
		}
		return CommandResult.usage(command.getCommandUpToPos(2), Arrays.asList("bankname"));
	}

}
