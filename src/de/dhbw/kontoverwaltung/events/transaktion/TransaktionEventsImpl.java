package de.dhbw.kontoverwaltung.events.transaktion;

import de.dhbw.kontoverwaltung.repositories.GeldAusgabeAutomatRepo;
import de.dhbw.kontoverwaltung.repositories.GiroKontoRepo;
import de.dhbw.kontoverwaltung.repositories.returns.GeldAusgabeAutomatReturn;
import de.dhbw.kontoverwaltung.repositories.returns.GiroKontoReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GeldAusgabeAutomat;
import de.dhbw.kontoverwaltung.types.GiroKonto;
import de.dhbw.kontoverwaltung.types.transaktion.AuszahlungTransaktion;
import de.dhbw.kontoverwaltung.types.transaktion.EinzahlungTransaktion;
import de.dhbw.kontoverwaltung.types.transaktion.KontoZuKontoTransaktion;
import de.dhbw.kontoverwaltung.types.transaktion.Transaktion;

public class TransaktionEventsImpl implements TransaktionEvents {

	private GiroKontoRepo kontoRepo;
	private GeldAusgabeAutomatRepo automatRepo;

	public TransaktionEventsImpl(GiroKontoRepo kontoRepo, GeldAusgabeAutomatRepo automatRepo) {
		this.kontoRepo = kontoRepo;
		this.automatRepo = automatRepo;
	}

	@Override
	public CommandResult transfer(String fromKonto, String toKonto, String betragString) {
		GiroKontoReturn kontoReturnFrom = kontoRepo.getGiroKontoById(fromKonto);
		if (!kontoReturnFrom.isSuccessful()) {
			return CommandResult.error("from konto unknown");
		}

		GiroKontoReturn kontoReturnTo = kontoRepo.getGiroKontoById(toKonto);
		if (!kontoReturnTo.isSuccessful()) {
			return CommandResult.error("to konto unknown");
		}

		EuroCentBetrag betrag = EuroCentBetrag.parse(betragString);
		if (betrag == null) {
			return CommandResult.error("betrag incorrect");
		}

		GiroKonto from = kontoReturnFrom.getInstance();
		GiroKonto to = kontoReturnTo.getInstance();

		if (!from.hatMehrGeldAls(betrag)) {
			return CommandResult.error("not enough money");
		}

		EuroCentBetrag fromBetrag = from.getBetrag();
		EuroCentBetrag toBetrag = to.getBetrag();

		EuroCentBetrag fromBetragNeu = fromBetrag.subtract(betrag);
		EuroCentBetrag toBetragNeu = toBetrag.add(betrag);

		GiroKontoReturn updateBetragFrom = kontoRepo.updateBetrag(from, fromBetragNeu);
		GiroKontoReturn updateBetragTo = kontoRepo.updateBetrag(to, toBetragNeu);

		Transaktion transaktion = new KontoZuKontoTransaktion(from, to, betrag);

		boolean success = updateBetragFrom.isSuccessful() && updateBetragTo.isSuccessful();

		if (success) {
			kontoRepo.addHistoryEntry(from, transaktion);
			kontoRepo.addHistoryEntry(to, transaktion);
			return CommandResult.success("transfer complete");
		} else {
			return CommandResult.error("failed during transfer");
		}
	}

	@Override
	public CommandResult cashOut(String automatString, String kontoString, String betragString, String pin) {
		GeldAusgabeAutomatReturn automatReturn = automatRepo.getGeldAusgabeAutomatById(automatString);
		if (!automatReturn.isSuccessful()) {
			return CommandResult.error("geldausgabeautomat unknown");
		}

		GiroKontoReturn kontoReturn = kontoRepo.getGiroKontoById(kontoString);
		if (!kontoReturn.isSuccessful()) {
			return CommandResult.error("konto unknown");
		}

		EuroCentBetrag auszahlungsBetrag = EuroCentBetrag.parse(betragString);
		if (auszahlungsBetrag == null) {
			return CommandResult.error("betrag incorrect");
		}

		GeldAusgabeAutomat geldAusgabeAutomat = automatReturn.getInstance();
		GiroKonto konto = kontoReturn.getInstance();

		if (!konto.getPin().isCorrectPin(pin)) {
			return CommandResult.error("pin is incorrect");
		}

		if (!konto.hatMehrGeldAls(auszahlungsBetrag)) {
			return CommandResult.error("not enough money on account");
		}

		if (!geldAusgabeAutomat.hatMehrGeldAls(auszahlungsBetrag)) {
			return CommandResult.error("not enough money in machine");
		}

		EuroCentBetrag automatBetrag = geldAusgabeAutomat.getBetrag();
		EuroCentBetrag automatBetragNeu = automatBetrag.subtract(auszahlungsBetrag);
		GeldAusgabeAutomatReturn updateAutomatBetrag = automatRepo.updateBetrag(geldAusgabeAutomat, automatBetragNeu);

		EuroCentBetrag kontoBetrag = konto.getBetrag();
		EuroCentBetrag kontoBetragNeu = kontoBetrag.subtract(auszahlungsBetrag);
		GiroKontoReturn updateKontoBetrag = kontoRepo.updateBetrag(konto, kontoBetragNeu);

		Transaktion transaktion = new AuszahlungTransaktion(geldAusgabeAutomat, konto, auszahlungsBetrag);

		if (updateAutomatBetrag.isSuccessful() && updateKontoBetrag.isSuccessful()) {
			kontoRepo.addHistoryEntry(konto, transaktion);
			return CommandResult.success("transfer complete");
		} else {
			return CommandResult.error("failed during transfer");
		}
	}

	@Override
	public CommandResult cashIn(String automatString, String kontoString, String betragString) {
		GeldAusgabeAutomatReturn automatReturn = automatRepo.getGeldAusgabeAutomatById(automatString);
		if (!automatReturn.isSuccessful()) {
			return CommandResult.error("geldausgabeautomat unknown");
		}

		GiroKontoReturn kontoReturn = kontoRepo.getGiroKontoById(kontoString);
		if (!kontoReturn.isSuccessful()) {
			return CommandResult.error("konto unknown");
		}

		EuroCentBetrag einzahlungsBetrag = EuroCentBetrag.parse(betragString);
		if (einzahlungsBetrag == null) {
			return CommandResult.error("betrag incorrect");
		}

		GeldAusgabeAutomat geldAusgabeAutomat = automatReturn.getInstance();
		GiroKonto konto = kontoReturn.getInstance();

		EuroCentBetrag automatBetrag = geldAusgabeAutomat.getBetrag();
		EuroCentBetrag automatBetragNeu = automatBetrag.add(einzahlungsBetrag);
		GeldAusgabeAutomatReturn updateAutomatBetrag = automatRepo.updateBetrag(geldAusgabeAutomat, automatBetragNeu);

		EuroCentBetrag kontoBetrag = konto.getBetrag();
		EuroCentBetrag kontoBetragNeu = kontoBetrag.add(einzahlungsBetrag);
		GiroKontoReturn updateBetrag = kontoRepo.updateBetrag(konto, kontoBetragNeu);

		Transaktion transaktion = new EinzahlungTransaktion(geldAusgabeAutomat, konto, einzahlungsBetrag);

		if (updateAutomatBetrag.isSuccessful() && updateBetrag.isSuccessful()) {
			kontoRepo.addHistoryEntry(konto, transaktion);
			return CommandResult.success("transfer complete");
		} else {
			return CommandResult.error("failed during transfer");
		}
	}

}
