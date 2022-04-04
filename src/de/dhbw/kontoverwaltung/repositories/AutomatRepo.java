package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.AutomatReturn;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;

public interface AutomatRepo {

	public AutomatReturn getAutomatById(String automatId);

	public AutomatReturn addAutomat(String automatId, EuroCentBetrag betrag);

	public AutomatReturn removeAutomatByName(String automatId);
	
	public AutomatReturn updateBetrag(GeldAusgabeAutomat automat, EuroCentBetrag betrag);

}
