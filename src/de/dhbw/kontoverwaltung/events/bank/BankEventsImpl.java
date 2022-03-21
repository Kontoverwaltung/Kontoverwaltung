package de.dhbw.kontoverwaltung.events.bank;

import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;

public class BankEventsImpl implements BankEvents {

	@Override
	public CommandResult getBank(String name) {
		BankReturn bankReturn = BankRepo.getBankByName(name);
		if (bankReturn.isSuccessful()) {
			return new ObjectToStringCommandResult(bankReturn.getInstance());
		}
		return CommandResult.error("failed to load bank");
	}

	@Override
	public CommandResult createBank(String name) {
		BankReturn bankReturn = BankRepo.addBank(name);
		if (bankReturn.isSuccessful()) {
			return CommandResult.success("bank created");
		}
		return CommandResult.error("failed to create bank");
	}

	@Override
	public CommandResult deleteBank(String name) {
		BankReturn bankReturn = BankRepo.removeBankByName(name);
		if (bankReturn.isSuccessful()) {
			return CommandResult.success("bank deleted");
		}
		return CommandResult.error("failed to delete bank");
	}

}
