package de.dhbw.kontoverwaltung.events.transfer;

import de.dhbw.kontoverwaltung.repositories.KontoRepo;
import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;
import de.dhbw.kontoverwaltung.types.GiroKonto;

public class TransferEventsImpl implements TransferEvents {

	private KontoRepo kontoRepo;

	public TransferEventsImpl(KontoRepo kontoRepo) {
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

		if (!from.hatMehrGeldAls(betrag)) {
			return CommandResult.error("not enough money");
		}

		from.subtractMoney(betrag);

		GiroKonto to = kontoReturnTo.getInstance();
		to.addMoney(betrag);

		return CommandResult.success("transfere complete");
	}

}
