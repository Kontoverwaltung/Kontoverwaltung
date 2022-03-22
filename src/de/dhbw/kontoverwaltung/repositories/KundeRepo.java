package de.dhbw.kontoverwaltung.repositories;

import de.dhbw.kontoverwaltung.database.FileHandlerImpl;
import de.dhbw.kontoverwaltung.database.PersistentDatabase;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.personen.Kunde;

public class KundeRepo {

	private static PersistentDatabase<Kunde> kundeDatabase = new PersistentDatabase<>(
			new FileHandlerImpl("Kunde"));

	public static KundeReturn getKundeById(String kundenId) {
		Kunde kunde = kundeDatabase.get(kundenId);
		if (kunde != null) {
			return new KundeReturn(true, kunde);
		}
		return new KundeReturn(false, null);
	}

	public static KundeReturn addKunde(Bank bank, String vorname, String nachname) {
		Kunde neuerKunde = new Kunde(bank, vorname, nachname);
		kundeDatabase.set(neuerKunde.getKundenId(), neuerKunde);
		return new KundeReturn(true, neuerKunde);
	}

	public static KundeReturn removeKundeById(String kundenId) {
		Kunde kunde = kundeDatabase.get(kundenId);
		if (kunde != null) {
			kundeDatabase.remove(kundenId);
			return new KundeReturn(true, kunde);
		}
		return new KundeReturn(false, null);
	}
}
