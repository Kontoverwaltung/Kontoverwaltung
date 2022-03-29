package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.Konto;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.personen.Person;

public interface KontoRepo {

	public KontoReturn getKontoById(String kontoId);

	public KontoReturn addKonto(Bank bank, Person inhaber, Pin pin);

	public KontoReturn updatePin(Konto konto, Pin newPin);

	public KontoReturn removeKontoById(String kontoId);

}
