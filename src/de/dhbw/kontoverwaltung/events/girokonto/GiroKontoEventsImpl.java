package de.dhbw.kontoverwaltung.events.girokonto;

import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.GiroKontoRepo;
import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.repositories.returns.GiroKontoReturn;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.GiroKonto;
import de.dhbw.kontoverwaltung.types.Person;
import de.dhbw.kontoverwaltung.types.Pin;

public class GiroKontoEventsImpl implements GiroKontoEvents {

	private GiroKontoRepo giroKontoRepo;
	private BankRepo bankRepo;
	private KundeRepo kundeRepo;

	public GiroKontoEventsImpl(GiroKontoRepo giroKontoRepo, BankRepo bankRepo, KundeRepo kundeRepo) {
		this.giroKontoRepo = giroKontoRepo;
		this.bankRepo = bankRepo;
		this.kundeRepo = kundeRepo;
	}

	@Override
	public CommandResult getGiroKonto(String giroKontoId) {
		GiroKontoReturn giroKontoReturn = giroKontoRepo.getGiroKontoById(giroKontoId);
		if (giroKontoReturn.isSuccessful()) {
			return new ObjectToStringCommandResult(giroKontoReturn.getInstance());
		}
		return CommandResult.error("failed to load girokonto");
	}

	@Override
	public CommandResult createNewGiroKonto(String bankName, String personId, String pin) {
		BankReturn bankReturn = bankRepo.getBankByName(bankName);
		if (!bankReturn.isSuccessful()) {
			return CommandResult.error("failed to load bank");
		}
		Bank bank = bankReturn.getInstance();

		KundeReturn kundeReturn = kundeRepo.getKundeById(personId);
		if (!kundeReturn.isSuccessful()) {
			return CommandResult.error("failed to load kunde");
		}
		Person inhaber = kundeReturn.getInstance();

		Pin pinObject = new Pin(pin);
		GiroKontoReturn giroKontoReturn = giroKontoRepo.addGiroKonto(bank, inhaber, pinObject);

		if (giroKontoReturn.isSuccessful()) {
			return CommandResult.success("girokonto " + giroKontoReturn.getInstance().getKontoId() + " created");
		}
		return CommandResult.error("failed to create girokonto");
	}

	@Override
	public CommandResult deleteGiroKonto(String giroKontoId) {
		GiroKontoReturn giroKontoToRemove = giroKontoRepo.getGiroKontoById(giroKontoId);
		if (giroKontoToRemove.isSuccessful()) {
			GiroKontoReturn giroKontoReturn = giroKontoRepo.removeGiroKonto(giroKontoToRemove.getInstance());
			if (giroKontoReturn.isSuccessful()) {
				return CommandResult.success("girokonto deleted");
			}

		}
		return CommandResult.error("failed to delete girokonto");
	}

	@Override
	public CommandResult changePin(String giroKontoId, String oldPin, String newPin) {
		GiroKontoReturn giroKontoReturn = giroKontoRepo.getGiroKontoById(giroKontoId);
		if (!giroKontoReturn.isSuccessful()) {
			return CommandResult.error("failed to load girokonto");
		}

		GiroKonto giroKonto = giroKontoReturn.getInstance();
		Pin giroKontoPin = giroKonto.getPin();

		if (!giroKontoPin.isCorrectPin(oldPin)) {
			return CommandResult.error("old pin is incorrect");
		}

		GiroKontoReturn pinUpdateReturn = giroKontoRepo.updatePin(giroKonto, new Pin(newPin));
		if (pinUpdateReturn.isSuccessful()) {
			return CommandResult.success("pin changed");
		}
		return CommandResult.error("failed to change pin");
	}

	@Override
	public CommandResult changeBank(String giroKontoId, String newBank) {
		GiroKontoReturn giroKontoReturn = giroKontoRepo.getGiroKontoById(giroKontoId);
		if (!giroKontoReturn.isSuccessful()) {
			return CommandResult.error("failed to load girokonto");
		}

		GiroKonto giroKonto = giroKontoReturn.getInstance();

		BankReturn newBankReturn = bankRepo.getBankByName(newBank);
		if (!newBankReturn.isSuccessful()) {
			return CommandResult.error("failed to find new bank");
		}

		GiroKontoReturn updateReturn = giroKontoRepo.updateBank(giroKonto, newBankReturn.getInstance());
		if (updateReturn.isSuccessful()) {
			return CommandResult.success("bank changed");
		}
		return CommandResult.error("failed to change bank");
	}

	@Override
	public CommandResult getKontoauszug(String giroKontoId) {
		GiroKontoReturn giroKontoReturn = giroKontoRepo.getGiroKontoById(giroKontoId);
		if (!giroKontoReturn.isSuccessful()) {
			return CommandResult.error("failed to load girokonto");
		}

		GiroKonto giroKonto = giroKontoReturn.getInstance();

		return CommandResult.success(giroKonto.getHistoryString());
	}

}
