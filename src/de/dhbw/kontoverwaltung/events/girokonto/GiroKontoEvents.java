package de.dhbw.kontoverwaltung.events.girokonto;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface GiroKontoEvents {

	public CommandResult getGiroKonto(String giroKontoId);

	public CommandResult createNewGiroKonto(String bankName, String personId, String pin);

	public CommandResult deleteGiroKonto(String giroKontoId);

	public CommandResult changePin(String giroKontoId, String oldPin, String newPin);

	public CommandResult changeBank(String giroKontoId, String newBank);

	public CommandResult getKontoauszug(String giroKontoId);

}
