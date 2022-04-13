package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.GiroKontoReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;
import de.dhbw.kontoverwaltung.types.Person;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.transaktion.Transaktion;

public class GiroKontoRepoImpl implements GiroKontoRepo {

	private PersistentDatabase<GiroKonto> giroKontoDatabase = new PersistentDatabase<>(
			new FileHandlerImpl("konto.csv"));

	@Override
	public GiroKontoReturn getGiroKontoById(String giroKontoId) {
		GiroKonto konto = giroKontoDatabase.get(giroKontoId);
		if (konto != null) {
			return new GiroKontoReturn(true, konto);
		}
		return new GiroKontoReturn(false, null);
	}

	@Override
	public GiroKontoReturn addGiroKonto(Bank bank, Person inhaber, Pin pin) {
		GiroKonto neuesKonto = new GiroKonto(bank, inhaber, pin);
		giroKontoDatabase.set(neuesKonto.getKontoId(), neuesKonto);
		return new GiroKontoReturn(true, neuesKonto);
	}

	@Override
	public GiroKontoReturn updatePin(GiroKonto giroKonto, Pin newPin) {
		giroKontoDatabase.remove(giroKonto.getKontoId());
		giroKonto.setPin(newPin);
		giroKontoDatabase.set(giroKonto.getKontoId(), giroKonto);
		return new GiroKontoReturn(true, giroKonto);
	}

	@Override
	public GiroKontoReturn removeGiroKonto(GiroKonto giroKonto) {
		giroKontoDatabase.remove(giroKonto.getKontoId());
		return new GiroKontoReturn(true, giroKonto);
	}

	@Override
	public GiroKontoReturn updateBetrag(GiroKonto konto, EuroCentBetrag betrag) {
		giroKontoDatabase.remove(konto.getKontoId());
		konto.setBetrag(betrag);
		giroKontoDatabase.set(konto.getKontoId(), konto);
		return new GiroKontoReturn(true, konto);
	}

	@Override
	public GiroKontoReturn updateBank(GiroKonto konto, Bank bank) {
		giroKontoDatabase.remove(konto.getKontoId());
		konto.setBank(bank);
		giroKontoDatabase.set(konto.getKontoId(), konto);
		return new GiroKontoReturn(true, konto);
	}

	@Override
	public GiroKontoReturn addHistoryEntry(GiroKonto konto, Transaktion transaktion) {
		giroKontoDatabase.remove(konto.getKontoId());
		konto.addHistoryEntry(transaktion);
		giroKontoDatabase.set(konto.getKontoId(), konto);
		return new GiroKontoReturn(true, konto);
	}

}
