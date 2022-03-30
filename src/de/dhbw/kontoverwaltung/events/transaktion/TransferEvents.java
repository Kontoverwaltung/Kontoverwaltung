package de.dhbw.kontoverwaltung.events.transaktion;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface TransferEvents {

	public CommandResult transfer(String fromKonto, String toKonto, String betrag);
	
}
