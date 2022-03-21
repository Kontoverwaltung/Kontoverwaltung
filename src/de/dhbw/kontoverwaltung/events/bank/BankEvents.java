package de.dhbw.kontoverwaltung.events.bank;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface BankEvents {
	
	public CommandResult getBank(String name);

	public CommandResult createBank(String name);
	
	public CommandResult deleteBank(String name);

}
