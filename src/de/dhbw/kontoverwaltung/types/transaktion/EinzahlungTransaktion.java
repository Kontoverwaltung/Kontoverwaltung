package de.dhbw.kontoverwaltung.types.transaktion;

import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;
import de.dhbw.kontoverwaltung.types.GiroKonto;

public class EinzahlungTransaktion extends Transaktion {

	private GeldAusgabeAutomat geldAusgabeAutomat;
	private GiroKonto giroKonto;

	public EinzahlungTransaktion(GeldAusgabeAutomat geldAusgabeAutomat, GiroKonto giroKonto, EuroCentBetrag betrag) {
		super();
		this.geldAusgabeAutomat = geldAusgabeAutomat;
		this.giroKonto = giroKonto;
		this.betrag = betrag;
	}

	public GeldAusgabeAutomat getGeldAusgabeAutomat() {
		return geldAusgabeAutomat;
	}

	public GiroKonto getGiroKonto() {
		return giroKonto;
	}

	@Override
	public String toString() {
		return "EinzahlungTransaktion [GeldAusgabeAutomat=" + geldAusgabeAutomat + ", GiroKontoID="
				+ giroKonto.getKontoId() + ", TransaktionID=" + transaktionId + ", Betrag=" + betrag + "]";
	}

}
