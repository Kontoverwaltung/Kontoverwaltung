package de.dhbw.kontoverwaltung.events.bank;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface BankEvents {

	public CommandResult getBank(String bankName);

	public CommandResult createBank(String bankName);

	public CommandResult deleteBank(String bankName);

}
