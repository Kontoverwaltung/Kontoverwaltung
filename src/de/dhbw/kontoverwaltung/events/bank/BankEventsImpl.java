package de.dhbw.kontoverwaltung.events.bank;

import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;

public class BankEventsImpl implements BankEvents {

	private BankRepo bankRepo;

	public BankEventsImpl(BankRepo bankRepo) {
		this.bankRepo = bankRepo;
	}

	@Override
	public CommandResult getBank(String bankName) {
		BankReturn bankReturn = bankRepo.getBankByName(bankName);
		if (bankReturn.isSuccessful()) {
			return new ObjectToStringCommandResult(bankReturn.getInstance());
		}
		return CommandResult.error("failed to load bank");
	}

	@Override
	public CommandResult createBank(String bankName) {
		BankReturn bankReturn = bankRepo.addBank(bankName);
		if (bankReturn.isSuccessful()) {
			return CommandResult.success("bank created");
		}
		return CommandResult.error("failed to create bank");
	}

	@Override
	public CommandResult deleteBank(String bankName) {
		BankReturn bankToRemove = bankRepo.getBankByName(bankName);
		if (bankToRemove.isSuccessful()) {
			BankReturn bankReturn = bankRepo.removeBank(bankToRemove.getInstance());
			if (bankReturn.isSuccessful()) {
				return CommandResult.success("bank deleted");
			}

		}
		return CommandResult.error("failed to delete bank");
	}

}
