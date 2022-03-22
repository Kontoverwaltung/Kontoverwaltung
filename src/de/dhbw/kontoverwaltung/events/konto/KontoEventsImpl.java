package de.dhbw.kontoverwaltung.events.konto;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.Betrag;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.personen.Person;

public class KontoEventsImpl implements KontoEvents {

	@Override
	public CommandResult getKonto(String kontoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult createNewKonto(Bank bank, Person inhaber, Betrag betrag, Pin pin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult editKonto(String oldKontoId, Bank newBank, Person newInhaber, Betrag newBetrag, Pin newPin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult deleteKonto(String kontoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandResult changePin(String kontoId, String newPin) {
		// TODO Auto-generated method stub
		return null;
	}

}
