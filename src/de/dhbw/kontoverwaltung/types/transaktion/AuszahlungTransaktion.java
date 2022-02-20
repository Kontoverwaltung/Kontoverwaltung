package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.Automat;
import de.dhbw.kontoverwaltung.types.Betrag;
import de.dhbw.kontoverwaltung.types.Konto;

public class AuszahlungTransaktion extends Transaktion {

	private Automat automat;
	private Konto konto;

	public AuszahlungTransaktion(Automat automat, Konto konto, Betrag betrag) {
		super();
		this.automat = automat;
		this.konto = konto;
		this.betrag = betrag;
	}

	public Automat getAutomat() {
		return automat;
	}

	public Konto getKonto() {
		return konto;
	}

}
