package de.dhbw.kontoverwaltung.events.kunde;

import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.CommandResult;
import de.dhbw.kontoverwaltung.types.Bank;

public class KundeEventsImpl implements KundeEvents {

	@Override
	public CommandResult createNewKunde(String bankName, String vorname, String nachname) {
		// TODO get Bank from Repo
		Bank bank = new Bank(bankName);
		KundeReturn answer = KundeRepo.addKunde(bank, vorname, nachname);
		if(answer.isSuccessful()) {
			return CommandResult.success("created " + answer.getKunde().getKundenId());
		}
		return CommandResult.error("kunde not created");
	}

}
