package de.dhbw.kontoverwaltung.terminal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.dhbw.kontoverwaltung.events.kunde.KundeEvents;

class CommandEventImplTest {

	private boolean assertsCalled;

	// objects
	private KundeEvents kundeEvents;

	@BeforeEach
	public void prepare() {
		assertsCalled = false;

		// reset all objects
		kundeEvents = null;
	}

	@Test
	void testCreatePerson() {
		// KUNDE CREATE {bankName} {Vorname} {Nachname} => personId
		String testCommand = "kunde create Volksbank-Bruchsal Peter Abriss";

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
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CommandResult editKunde(String oldKundenId, String newBankName, String newVorname,
					String newNachname) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CommandResult deleteKunde(String kundenId) {
				// TODO Auto-generated method stub
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

	private CommandResult executeOnTarget(String command) {
		CommandParser target = createTarget();
		return target.onInput(command);
	}

	private CommandParser createTarget() {
		return new CommandParser(kundeEvents);
	}

}
