package de.dhbw.kontoverwaltung.events.konto;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface KontoEvents {

	public CommandResult getKonto(String kontoId);

	public CommandResult createNewKonto(String bankName, String personId, String pin);

	public CommandResult deleteKonto(String kontoId);

	public CommandResult changePin(String kontoId, String oldPin, String newPin);

	public CommandResult changeBank(String kontoId, String newBank);
	
}
