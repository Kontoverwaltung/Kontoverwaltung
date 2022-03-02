package de.dhbw.kontoverwaltung.repositories;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.personen.Kunde;

public class KundeRepo {

	private static List<Kunde> kunden = new ArrayList<>();

	public static KundeReturn getKundeById(String kundenId) {
		for (Kunde kunde : kunden) {
			if (kunde.getKundenId() == kundenId) {
				return new KundeReturn(true, kunde);
			}
		}
		return new KundeReturn(false, null);
	}

	public static KundeReturn addKunde(Bank bank, String vorname, String nachname) {
		Kunde neuerKunde = new Kunde(bank, vorname, nachname);
		kunden.add(neuerKunde);
		return new KundeReturn(true, neuerKunde);
	}

	public static KundeReturn removeKundeById(String kundenId) {
		for (Kunde kunde : kunden) {
			if (kunde.getKundenId() == kundenId) {
				kunden.remove(kunde);
				return new KundeReturn(true, kunde);
			}
		}
		return new KundeReturn(false, null);
	}
}
