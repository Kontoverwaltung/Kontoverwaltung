package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;

public class EinzahlungTransaktion extends Transaktion {

	private GeldAusgabeAutomat automat;
	private GiroKonto konto;

	public EinzahlungTransaktion(GeldAusgabeAutomat automat, GiroKonto konto, EuroCentBetrag betrag) {
		super();
		this.automat = automat;
		this.konto = konto;
		this.betrag = betrag;
	}

	public GeldAusgabeAutomat getAutomat() {
		return automat;
	}

	public GiroKonto getKonto() {
		return konto;
	}

}
