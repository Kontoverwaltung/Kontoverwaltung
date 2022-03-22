package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.Betrag;
import de.dhbw.kontoverwaltung.types.Konto;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.personen.Person;

public class KontoRepo {

	private static PersistentDatabase<Konto> kontoDatabase = new PersistentDatabase<>(
			new FileHandlerImpl("Konto"));

	public static KontoReturn getKontoById(String kontoId) {
		Konto konto = kontoDatabase.get(kontoId);
		if (konto != null) {
			return new KontoReturn(true, konto);
		}
		return new KontoReturn(false, null);
	}

	public static KontoReturn addKonto(Bank bank, Person inhaber, Betrag betrag, Pin pin) {
		Konto neuesKonto = new Konto(bank, inhaber, betrag, pin);
		kontoDatabase.set(neuesKonto.getKontoId(), neuesKonto);
		return new KontoReturn(true, neuesKonto);
	}

	public static KontoReturn removeKontoById(String kontoId) {
		Konto konto = kontoDatabase.get(kontoId);
		if (konto != null) {
			kontoDatabase.remove(kontoId);
			return new KontoReturn(true, konto);
		}
		return new KontoReturn(false, null);
	}
}
