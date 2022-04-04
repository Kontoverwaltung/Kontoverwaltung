package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.AutomatReturn;
import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;

public class AutomatRepoImpl implements AutomatRepo {

	private PersistentDatabase<GeldAusgabeAutomat> bankDatabase = new PersistentDatabase<>(new FileHandlerImpl("automat.csv"));

	public AutomatReturn addAutomat(String automatId, EuroCentBetrag betrag) {
		GeldAusgabeAutomat neuerAutomat = new GeldAusgabeAutomat(automatId, betrag);
		bankDatabase.set(neuerAutomat.getAutomatId(), neuerAutomat);
		return new AutomatReturn(true, neuerAutomat);
	}

	@Override
	public AutomatReturn getAutomatById(String automatId) {
		GeldAusgabeAutomat automat = bankDatabase.get(automatId);
		if (automat != null) {
			return new AutomatReturn(true, automat);
		}
		return new AutomatReturn(false, null);
	}

	@Override
	public AutomatReturn removeAutomatByName(String automatId) {
		GeldAusgabeAutomat automat = bankDatabase.get(automatId);
		if (automat != null) {
			bankDatabase.remove(automatId);
			return new AutomatReturn(true, automat);
		}
		return new AutomatReturn(false, null);
	}

	@Override
	public AutomatReturn updateBetrag(GeldAusgabeAutomat automat, EuroCentBetrag betrag) {
		bankDatabase.remove(automat.getAutomatId());
		automat.setBetrag(betrag);
		bankDatabase.set(automat.getAutomatId(), automat);
		return new AutomatReturn(true, automat);
	}
}
