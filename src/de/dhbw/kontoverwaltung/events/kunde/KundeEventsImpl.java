package de.dhbw.kontoverwaltung.events.kunde;

import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.command.CommandResult;
import de.dhbw.kontoverwaltung.types.Bank;

public class KundeEventsImpl implements KundeEvents {

	@Override
	public CommandResult getKunde(String kundenId) {
		KundeReturn answer = KundeRepo.getKundeById(kundenId);
		if (answer.isSuccessful()) {
			return CommandResult.success("found " + answer.getInstance().getKundenId());
		}
		return CommandResult.error("kunde not found");
	}

	@Override
	public CommandResult createNewKunde(String bankName, String vorname, String nachname) {
		// TODO get Bank from Repo
		Bank bank = new Bank(bankName);
		KundeReturn answer = KundeRepo.addKunde(bank, vorname, nachname);
		if (answer.isSuccessful()) {
			return CommandResult.success("created " + answer.getInstance().getKundenId());
		}
		return CommandResult.error("kunde not created");
	}

	@Override
	public CommandResult editKunde(String oldKundenId, String newBankName, String newVorname, String newNachname) {
		CommandResult deletionAnswer = deleteKunde(oldKundenId);
		if (deletionAnswer.isSuccessful()) {
			CommandResult creationAnswer = createNewKunde(newBankName, newVorname, newNachname);
			if (creationAnswer.isSuccessful()) {
				return CommandResult.success(deletionAnswer.getAdditionalInfo() + ", " + creationAnswer.getAdditionalInfo());
			}
		}
		return CommandResult.error("kunde not edited");
	}

	@Override
	public CommandResult deleteKunde(String kundenId) {
		KundeReturn answer = KundeRepo.removeKundeById(kundenId);
		if (answer.isSuccessful()) {
			return CommandResult.success("deleted " + answer.getInstance().getKundenId());
		}
		return CommandResult.error("kunde not deleted");
	}

}
