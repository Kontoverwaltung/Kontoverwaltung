package de.dhbw.kontoverwaltung.terminal.process.bank;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.terminal.SplittedCommand;
import de.dhbw.kontoverwaltung.terminal.command.CommandParser;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class CreateBankCommand extends CommandParser {

	private BankEvents bankEvents;

	public CreateBankCommand(BankEvents bankEvents) {
		super();
		this.bankEvents = bankEvents;
	}

	@Override
	public CommandResult execute(SplittedCommand command) {
		if (command.argsSize() == 3) {
			String bankName = command.getStringAt(2);
			return bankEvents.createBank(bankName);
		}
		return CommandResult.commandNotFound();
	}

}
