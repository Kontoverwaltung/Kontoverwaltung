package de.dhbw.kontoverwaltung.events.kunde;

import de.dhbw.kontoverwaltung.repositories.BankRepo;
import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.BankReturn;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;
import de.dhbw.kontoverwaltung.types.Bank;
import de.dhbw.kontoverwaltung.types.personen.Kunde;

public class KundeEventsImpl implements KundeEvents {

	private BankRepo bankRepo;
	private KundeRepo kundeRepo;

	public KundeEventsImpl(BankRepo bankRepo, KundeRepo kundeRepo) {
		this.bankRepo = bankRepo;
		this.kundeRepo = kundeRepo;
	}

	@Override
	public CommandResult getKunde(String kundenId) {
		KundeReturn answer = kundeRepo.getKundeById(kundenId);
		if (answer.isSuccessful()) {
			Kunde kunde = answer.getInstance();
			return new ObjectToStringCommandResult(kunde);
		}
		return CommandResult.error("kunde not found");
	}

	@Override
	public CommandResult createNewKunde(String bankName, String vorname, String nachname) {
		BankReturn bankReturn = bankRepo.getBankByName(bankName);
		if (!bankReturn.isSuccessful()) {
			return CommandResult.error("failed to find bank");
		}
		Bank bank = bankReturn.getInstance();
		KundeReturn answer = kundeRepo.addKunde(bank, vorname, nachname);
		if (answer.isSuccessful()) {
			return CommandResult.success("kunde " + answer.getInstance().getKundenId() + " created");
		}
		return CommandResult.error("kunde not created");
	}

	public CommandResult deleteKunde(String kundenId) {
		KundeReturn answer = kundeRepo.removeKundeById(kundenId);
		if (answer.isSuccessful()) {
			return CommandResult.success("deleted " + answer.getInstance().getKundenId());
		}
		return CommandResult.error("kunde not deleted");
	}

}
