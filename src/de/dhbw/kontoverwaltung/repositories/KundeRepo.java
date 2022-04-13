package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.types.Person;

public interface KundeRepo {

	public KundeReturn getKundeById(String kundenId);

	public KundeReturn addKunde(String vorname, String nachname);

	public KundeReturn removeKunde(Person kunde);

}
