package de.dhbw.kontoverwaltung.repositories;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.Betrag;
import de.dhbw.kontoverwaltung.types.Konto;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.personen.Person;

public class KontoRepo {

	private static List<Konto> konten = new ArrayList<>();

	public static KontoReturn getKontoById(String kontoId) {
		for (Konto konto : konten) {
			if (konto.getKontoId().equals(kontoId)) {
				return new KontoReturn(true, konto);
			}
		}
		return new KontoReturn(false, null);
	}

	public static KontoReturn addKonto(Bank bank, Person inhaber, Betrag betrag, Pin pin) {
		Konto neuesKonto = new Konto(bank, inhaber, betrag, pin);
		konten.add(neuesKonto);
		return new KontoReturn(true, neuesKonto);
	}

	public static KontoReturn removeKontoById(String kontoId) {
		for (Konto konto : konten) {
			if (konto.getKontoId().equals(kontoId)) {
				konten.remove(konto);
				return new KontoReturn(true, konto);
			}
		}
		return new KontoReturn(false, null);
	}
}
