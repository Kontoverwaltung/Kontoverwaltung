package de.dhbw.kontoverwaltung.events.transaktion;

import de.dhbw.kontoverwaltung.repositories.KontoRepo;
import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;

public class TransaktionEventsImpl implements TransaktionEvents {

	private KontoRepo kontoRepo;

	public TransaktionEventsImpl(KontoRepo kontoRepo) {
		this.kontoRepo = kontoRepo;
	}

	@Override
	public CommandResult transfer(String fromKonto, String toKonto, String betragString) {
		KontoReturn kontoReturnFrom = kontoRepo.getKontoById(fromKonto);
		if (!kontoReturnFrom.isSuccessful()) {
			return CommandResult.error("from konto unknown");
		}

		KontoReturn kontoReturnTo = kontoRepo.getKontoById(toKonto);
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

		KontoReturn updateBetragFrom = kontoRepo.updateBetrag(from, fromBetragNeu);
		KontoReturn updateBetragTo = kontoRepo.updateBetrag(to, toBetragNeu);

		boolean success = updateBetragFrom.isSuccessful() && updateBetragTo.isSuccessful();

		if (success) {
			return CommandResult.success("transfere complete");
		} else {
			return CommandResult.error("failed during transfer");
		}
	}

}
