package de.dhbw.kontoverwaltung.events.bank;

import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public interface BankEvents {

	public CommandResult createBank(String name);

	public CommandResult deleteBank(String name);

}
