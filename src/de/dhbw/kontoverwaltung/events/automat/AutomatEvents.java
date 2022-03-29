package de.dhbw.kontoverwaltung.events.automat;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

public interface AutomatEvents {

	public CommandResult getAutomat(String automatId);

	public CommandResult createAutomat(String automatId, String betragFilled);

	public CommandResult deleteAutomat(String automatId);

}
