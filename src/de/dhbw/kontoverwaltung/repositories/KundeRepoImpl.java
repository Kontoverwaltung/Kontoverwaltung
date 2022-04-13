package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.types.Person;

public class KundeRepoImpl implements KundeRepo {

	private PersistentDatabase<Person> kundeDatabase = new PersistentDatabase<>(new FileHandlerImpl("kunde.csv"));

	@Override
	public KundeReturn getKundeById(String kundenId) {
		Person kunde = kundeDatabase.get(kundenId);
		if (kunde != null) {
			return new KundeReturn(true, kunde);
		}
		return new KundeReturn(false, null);
	}

	@Override
	public KundeReturn addKunde(String vorname, String nachname) {
		Person neuerKunde = new Person(vorname, nachname);
		kundeDatabase.set(neuerKunde.getKundenId(), neuerKunde);
		return new KundeReturn(true, neuerKunde);
	}

	@Override
	public KundeReturn removeKunde(Person kunde) {
		kundeDatabase.remove(kunde.getKundenId());
		return new KundeReturn(true, kunde);
	}
}
