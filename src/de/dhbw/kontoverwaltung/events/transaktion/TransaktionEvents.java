package de.dhbw.kontoverwaltung.events.transaktion;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface TransaktionEvents {

	public CommandResult transfer(String fromKonto, String toKonto, String betrag);
	
	public CommandResult cashOut(String automat, String konto, String betrag, String pin);
	
	public CommandResult cashIn(String automat, String konto, String betrag);
	
}
