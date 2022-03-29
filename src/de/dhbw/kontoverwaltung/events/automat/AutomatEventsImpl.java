package de.dhbw.kontoverwaltung.events.automat;

import de.dhbw.kontoverwaltung.repositories.AutomatRepo;
import de.dhbw.kontoverwaltung.repositories.returns.AutomatReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;

public class AutomatEventsImpl implements AutomatEvents {

	private AutomatRepo automatRepo;

	public AutomatEventsImpl(AutomatRepo automatRepo) {
		this.automatRepo = automatRepo;
	}

	@Override
	public CommandResult getAutomat(String automatId) {
		AutomatReturn automatReturn = automatRepo.getAutomatById(automatId);
		if (automatReturn.isSuccessful()) {
			return new ObjectToStringCommandResult(automatReturn.getInstance());
		}
		return CommandResult.error("failed to load automat");
	}

	@Override
	public CommandResult createAutomat(String automatId, String betragFilled) {
		EuroCentBetrag filled = EuroCentBetrag.parse(betragFilled);
		if (filled == null) {
			return CommandResult.error("betrag incorrect");
		}
		
		CommandResult getAutomatResult = getAutomat(automatId);
		if(getAutomatResult.isSuccessful()) {
			return CommandResult.error("automat with this id already exists");
		}

		AutomatReturn automatReturn = automatRepo.addAutomat(automatId, filled);
		if (automatReturn.isSuccessful()) {
			return CommandResult.success("automat " + automatReturn.getInstance().getAutomatId() + " created");
		}
		return CommandResult.error("failed to create automat");
	}

	@Override
	public CommandResult deleteAutomat(String automatId) {
		AutomatReturn automatReturn = automatRepo.removeAutomatByName(automatId);
		if (automatReturn.isSuccessful()) {
			return CommandResult.success("automat deleted");
		}
		return CommandResult.error("failed to delete automat");
	}

}
