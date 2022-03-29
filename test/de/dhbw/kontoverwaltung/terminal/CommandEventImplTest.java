package de.dhbw.kontoverwaltung.terminal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.dhbw.kontoverwaltung.events.bank.BankEvents;
import de.dhbw.kontoverwaltung.events.konto.KontoEvents;
import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;
import de.dhbw.kontoverwaltung.events.transfer.TransferEvents;
import de.dhbw.kontoverwaltung.terminal.command.BaseCommandParser;
import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

class CommandEventImplTest {

	private boolean assertsCalled;

	// objects
	private KundeEvents kundeEvents;
	private BankEvents bankEvents;
	private KontoEvents kontoEvents;
	private TransferEvents transferEvents;

	@BeforeEach
	public void prepare() {
		assertsCalled = false;

		// reset all objects
		kundeEvents = null;
		bankEvents = null;
		kontoEvents = null;
	}

	@Test
	void testCreatePerson() {
		// KUNDE CREATE {bankName} {Vorname} {Nachname} => personId
		SplittedCommand testCommand = new SplittedCommand("kunde create Volksbank-Bruchsal Peter Abriss", " ");

		// prepare
		kundeEvents = new KundeEvents() {
			@Override
			public CommandResult createNewKunde(String bankName, String vorname, String nachname) {
				assertThat(bankName, is("Volksbank-Bruchsal"));
				assertThat(vorname, is("Peter"));
				assertThat(nachname, is("Abriss"));

				assertsCalled = true;
				return CommandResult.success("created");
			}

			@Override
			public CommandResult getKunde(String kundenId) {
				return null;
			}

			@Override
			public CommandResult deleteKunde(String kundenId) {
				return null;
			}
		};

		// execute
		CommandResult result = executeOnTarget(testCommand);

		// assert
		assertThat(assertsCalled, is(true));
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getAdditionalInfo(), is("created"));
	}

	private CommandResult executeOnTarget(SplittedCommand command) {
		BaseCommandParser target = createTarget();
		return target.execute(command);
	}

	private BaseCommandParser createTarget() {
		return new BaseCommandParser(kundeEvents, bankEvents, kontoEvents, transferEvents);
	}

}
