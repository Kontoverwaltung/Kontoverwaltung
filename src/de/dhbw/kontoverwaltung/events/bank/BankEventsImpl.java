package de.dhbw.kontoverwaltung.events.bank;

import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

public class BankEventsImpl implements BankEvents {

	@Override
	public CommandResult createBank(String name) {
		return CommandResult.error("not implemented yet");
	}

	@Override
	public CommandResult deleteBank(String name) {
		return CommandResult.error("not implemented yet");
	}

}
