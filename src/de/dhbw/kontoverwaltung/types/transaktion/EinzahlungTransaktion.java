package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.Konto;

public class EinzahlungTransaktion extends Transaktion {

	private GeldAusgabeAutomat automat;
	private Konto konto;

	public EinzahlungTransaktion(GeldAusgabeAutomat automat, Konto konto, EuroCentBetrag betrag) {
		super();
		this.automat = automat;
		this.konto = konto;
		this.betrag = betrag;
	}

	public GeldAusgabeAutomat getAutomat() {
		return automat;
	}

	public Konto getKonto() {
		return konto;
	}

}
