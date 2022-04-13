package de.dhbw.kontoverwaltung.events.geldausgabeautomat;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface GeldAusgabeAutomatEvents {

	public CommandResult getGeldAusgabeAutomat(String geldAusgabeAutomatId);

	public CommandResult createGeldAusgabeAutomat(String geldAusgabeAutomatId, String betragFilled);

	public CommandResult deleteGeldAusgabeAutomat(String geldAusgabeAutomatId);

}
