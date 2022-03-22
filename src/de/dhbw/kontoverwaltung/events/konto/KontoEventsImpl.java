package de.dhbw.kontoverwaltung.events.konto;

import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.KontoRepo;
import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.repositories.returns.KontoReturn;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.Konto;
import de.dhbw.kontoverwaltung.types.Pin;
import de.dhbw.kontoverwaltung.types.personen.Person;

public class KontoEventsImpl implements KontoEvents {

	@Override
	public CommandResult getKonto(String kontoId) {
		KontoReturn kontoReturn = KontoRepo.getKontoById(kontoId);
		if (kontoReturn.isSuccessful()) {
			return new ObjectToStringCommandResult(kontoReturn.getInstance());
		}
		return CommandResult.error("failed to load konto");
	}

	@Override
	public CommandResult createNewKonto(String bankName, String personId, String pin) {
		BankReturn bankReturn = BankRepo.getBankByName(bankName);
		if (!bankReturn.isSuccessful()) {
			return CommandResult.error("failed to load bank");
		}
		Bank bank = bankReturn.getInstance();

		KundeReturn kundeReturn = KundeRepo.getKundeById(personId);
		if (!kundeReturn.isSuccessful()) {
			return CommandResult.error("failed to load kunde");
		}
		Person inhaber = kundeReturn.getInstance();

		Pin pinObject = new Pin(pin);
		KontoReturn kontoReturn = KontoRepo.addKonto(bank, inhaber, pinObject);

		if (kontoReturn.isSuccessful()) {
			return CommandResult.success("konto " +  kontoReturn.getInstance().getKontoId() + " created");
		}
		return CommandResult.error("failed to create konto");
	}

	@Override
	public CommandResult deleteKonto(String kontoId) {
		KontoReturn kontoReturn = KontoRepo.removeKontoById(kontoId);
		if (kontoReturn.isSuccessful()) {
			return CommandResult.success("konto deleted");
		}
		return CommandResult.error("failed to delete konto");
	}

	@Override
	public CommandResult changePin(String kontoId, String oldPin, String newPin) {
		KontoReturn kontoReturn = KontoRepo.getKontoById(kontoId);
		if (!kontoReturn.isSuccessful()) {
			return CommandResult.error("failed to load konto");
		}

		Konto konto = kontoReturn.getInstance();
		Pin kontoPin = konto.getPin();

		if (!kontoPin.isCorrectPin(oldPin)) {
			return CommandResult.error("old pin is incorrect");
		}

		KontoReturn pinUpdateReturn = KontoRepo.updatePin(konto, new Pin(newPin));
		if (pinUpdateReturn.isSuccessful()) {
			return CommandResult.success("pin changed");
		}
		return CommandResult.error("failed to change pin");
	}

}
