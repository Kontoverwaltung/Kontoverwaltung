package de.dhbw.kontoverwaltung.events.konto;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.Betrag;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.personen.Person;

public interface KontoEvents {

	public CommandResult getKonto(String kontoId);

	public CommandResult createNewKonto(Bank bank, Person inhaber, Betrag betrag, Pin pin);

	public CommandResult editKonto(String oldKontoId, Bank newBank, Person newInhaber, Betrag newBetrag, Pin newPin);

	public CommandResult deleteKonto(String kontoId);

	public CommandResult changePin(String kontoId, String newPin);

}
