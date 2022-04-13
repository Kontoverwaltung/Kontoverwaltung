package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.GeldAusgabeAutomatReturn;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;

public class GeldAusgabeAutomatRepoImpl implements GeldAusgabeAutomatRepo {

	private PersistentDatabase<GeldAusgabeAutomat> geldAusgabeAutomatDatabase = new PersistentDatabase<>(
			new FileHandlerImpl("automat.csv"));

	@Override
	public GeldAusgabeAutomatReturn addGeldAusgabeAutomat(String geldAusgabeAutomatId, EuroCentBetrag betrag) {
		GeldAusgabeAutomat neuerGeldAusgabeAutomat = new GeldAusgabeAutomat(geldAusgabeAutomatId, betrag);
		geldAusgabeAutomatDatabase.set(neuerGeldAusgabeAutomat.getAutomatId(), neuerGeldAusgabeAutomat);
		return new GeldAusgabeAutomatReturn(true, neuerGeldAusgabeAutomat);
	}

	@Override
	public GeldAusgabeAutomatReturn getGeldAusgabeAutomatById(String geldAusgabeAutomatId) {
		GeldAusgabeAutomat geldAusgabeAutomat = geldAusgabeAutomatDatabase.get(geldAusgabeAutomatId);
		if (geldAusgabeAutomat != null) {
			return new GeldAusgabeAutomatReturn(true, geldAusgabeAutomat);
		}
		return new GeldAusgabeAutomatReturn(false, null);
	}

	@Override
	public GeldAusgabeAutomatReturn removeGeldAusgabeAutomat(GeldAusgabeAutomat geldAusgabeAutomat) {
		geldAusgabeAutomatDatabase.remove(geldAusgabeAutomat.getAutomatId());
		return new GeldAusgabeAutomatReturn(true, geldAusgabeAutomat);
	}

	@Override
	public GeldAusgabeAutomatReturn updateBetrag(GeldAusgabeAutomat geldAusgabeAutomat, EuroCentBetrag betrag) {
		geldAusgabeAutomatDatabase.remove(geldAusgabeAutomat.getAutomatId());
		geldAusgabeAutomat.setBetrag(betrag);
		geldAusgabeAutomatDatabase.set(geldAusgabeAutomat.getAutomatId(), geldAusgabeAutomat);
		return new GeldAusgabeAutomatReturn(true, geldAusgabeAutomat);
	}
}
