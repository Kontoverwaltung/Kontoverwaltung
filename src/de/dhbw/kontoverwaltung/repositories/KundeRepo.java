package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.types.Bank;

public interface KundeRepo {

	public KundeReturn getKundeById(String kundenId);

	public KundeReturn addKunde(Bank bank, String vorname, String nachname);

	public KundeReturn removeKundeById(String kundenId);

}
