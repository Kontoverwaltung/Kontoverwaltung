package de.dhbw.kontoverwaltung.events.transaktion;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface TransaktionEvents {

	public CommandResult transfer(String fromKonto, String toKonto, String betrag);
	
}
