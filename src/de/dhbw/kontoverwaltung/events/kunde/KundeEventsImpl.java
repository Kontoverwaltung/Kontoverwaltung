package de.dhbw.kontoverwaltung.events.kunde;

import de.dhbw.kontoverwaltung.repositories.KundeRepo;
import de.dhbw.kontoverwaltung.repositories.returns.KundeReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;
import de.dhbw.kontoverwaltung.types.Person;

public class KundeEventsImpl implements KundeEvents {

	private KundeRepo kundeRepo;

	public KundeEventsImpl(KundeRepo kundeRepo) {
		this.kundeRepo = kundeRepo;
	}

	@Override
	public CommandResult getKunde(String kundenId) {
		KundeReturn answer = kundeRepo.getKundeById(kundenId);
		if (answer.isSuccessful()) {
			Person kunde = answer.getInstance();
			return new ObjectToStringCommandResult(kunde);
		}
		return CommandResult.error("kunde not found");
	}

	@Override
	public CommandResult createNewKunde(String vorname, String nachname) {
		KundeReturn answer = kundeRepo.addKunde(vorname, nachname);
		if (answer.isSuccessful()) {
			return CommandResult.success("kunde " + answer.getInstance().getKundenId() + " created");
		}
		return CommandResult.error("kunde not created");
	}

	public CommandResult deleteKunde(String kundenId) {
		KundeReturn kundeToRemove = kundeRepo.getKundeById(kundenId);
		if (kundeToRemove.isSuccessful()) {
			KundeReturn kundeReturn = kundeRepo.removeKunde(kundeToRemove.getInstance());
			if (kundeReturn.isSuccessful()) {
				return CommandResult.success("kunde deleted");
			}

		}
		return CommandResult.error("failed to delete kunde");
	}

}
