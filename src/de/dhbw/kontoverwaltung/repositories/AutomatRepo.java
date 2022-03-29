package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.AutomatReturn;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;

public interface AutomatRepo {

	public AutomatReturn getAutomatById(String automatId);

	public AutomatReturn addAutomat(String automatId, EuroCentBetrag betrag);

	public AutomatReturn removeAutomatByName(String automatId);

}
