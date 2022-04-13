package de.dhbw.kontoverwaltung.events.geldausgabeautomat;

import de.dhbw.kontoverwaltung.repositories.GeldAusgabeAutomatRepo;
import de.dhbw.kontoverwaltung.repositories.returns.GeldAusgabeAutomatReturn;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;
import de.dhbw.kontoverwaltung.terminal.command.results.ObjectToStringCommandResult;
import de.dhbw.kontoverwaltung.types.EuroCentBetrag;

public class GeldAusgabeAutomatEventsImpl implements GeldAusgabeAutomatEvents {

	private GeldAusgabeAutomatRepo geldAusgabeAutomatRepo;

	public GeldAusgabeAutomatEventsImpl(GeldAusgabeAutomatRepo geldAusgabeAutomatRepo) {
		this.geldAusgabeAutomatRepo = geldAusgabeAutomatRepo;
	}

	@Override
	public CommandResult getGeldAusgabeAutomat(String geldAusgabeAutomatId) {
		GeldAusgabeAutomatReturn geldAusgabeAutomatReturn = geldAusgabeAutomatRepo
				.getGeldAusgabeAutomatById(geldAusgabeAutomatId);
		if (geldAusgabeAutomatReturn.isSuccessful()) {
			return new ObjectToStringCommandResult(geldAusgabeAutomatReturn.getInstance());
		}
		return CommandResult.error("failed to load geldausgabeautomat");
	}

	@Override
	public CommandResult createGeldAusgabeAutomat(String geldAusgabeAutomatId, String betragFilled) {
		EuroCentBetrag filled = EuroCentBetrag.parse(betragFilled);
		if (filled == null) {
			return CommandResult.error("betrag incorrect");
		}

		CommandResult getgeldAusgabeAutomatResult = getGeldAusgabeAutomat(geldAusgabeAutomatId);
		if (getgeldAusgabeAutomatResult.isSuccessful()) {
			return CommandResult.error("geldausgabeautomat with this id already exists");
		}

		GeldAusgabeAutomatReturn geldAusgabeAutomatReturn = geldAusgabeAutomatRepo
				.addGeldAusgabeAutomat(geldAusgabeAutomatId, filled);
		if (geldAusgabeAutomatReturn.isSuccessful()) {
			return CommandResult.success(
					"geldausgabeautomat " + geldAusgabeAutomatReturn.getInstance().getAutomatId() + " created");
		}
		return CommandResult.error("failed to create geldausgabeautomat");
	}

	@Override
	public CommandResult deleteGeldAusgabeAutomat(String geldAusgabeAutomatId) {
		GeldAusgabeAutomatReturn geldAusgabeAutomatToRemove = geldAusgabeAutomatRepo
				.getGeldAusgabeAutomatById(geldAusgabeAutomatId);
		if (geldAusgabeAutomatToRemove.isSuccessful()) {
			GeldAusgabeAutomatReturn geldAusgabeAutomatReturn = geldAusgabeAutomatRepo
					.removeGeldAusgabeAutomat(geldAusgabeAutomatToRemove.getInstance());
			if (geldAusgabeAutomatReturn.isSuccessful()) {
				return CommandResult.success("geldausgabeautomat deleted");
			}

		}
		return CommandResult.error("failed to delete geldausgabeautomat");
	}

}
