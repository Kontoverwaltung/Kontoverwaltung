package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.GeldAusgabeAutomatReturn;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;

public interface GeldAusgabeAutomatRepo {

	public GeldAusgabeAutomatReturn getGeldAusgabeAutomatById(String geldAusgabeAutomatId);

	public GeldAusgabeAutomatReturn addGeldAusgabeAutomat(String geldAusgabeAutomatId, EuroCentBetrag betrag);

	public GeldAusgabeAutomatReturn removeGeldAusgabeAutomat(GeldAusgabeAutomat geldAusgabeAutomat);

	public GeldAusgabeAutomatReturn updateBetrag(GeldAusgabeAutomat geldAusgabeAutomat, EuroCentBetrag betrag);

}
