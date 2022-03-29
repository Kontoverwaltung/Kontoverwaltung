package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.Konto;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.personen.Person;

public class KontoRepoImpl implements KontoRepo {

	private PersistentDatabase<Konto> kontoDatabase = new PersistentDatabase<>(new FileHandlerImpl("konto.csv"));

	public KontoReturn getKontoById(String kontoId) {
		Konto konto = kontoDatabase.get(kontoId);
		if (konto != null) {
			return new KontoReturn(true, konto);
		}
		return new KontoReturn(false, null);
	}

	public KontoReturn addKonto(Bank bank, Person inhaber, Pin pin) {
		Konto neuesKonto = new Konto(bank, inhaber, pin);
		kontoDatabase.set(neuesKonto.getKontoId(), neuesKonto);
		return new KontoReturn(true, neuesKonto);
	}

	public KontoReturn updatePin(Konto konto, Pin newPin) {
		kontoDatabase.remove(konto.getKontoId());
		konto.setPin(newPin);
		kontoDatabase.set(konto.getKontoId(), konto);
		return new KontoReturn(true, konto);
	}

	public KontoReturn removeKontoById(String kontoId) {
		Konto konto = kontoDatabase.get(kontoId);
		if (konto != null) {
			kontoDatabase.remove(kontoId);
			return new KontoReturn(true, konto);
		}
		return new KontoReturn(false, null);
	}
}
