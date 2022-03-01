package de.dhbw.kontoverwaltung.terminal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import de.dhbw.kontoverwaltung.terminal.command.CommandResult;

class CommandResultTest {

	@Test
	void testSuccessData() {
		CommandResult target = CommandResult.success("test ok");

		assertThat(target.isSuccessful(), is(true));
		assertThat(target.getAdditionalInfo(), is("test ok"));
	}

	@Test
	void testErrorData() {
		CommandResult target = CommandResult.error("test error");

		assertThat(target.isSuccessful(), is(false));
		assertThat(target.getAdditionalInfo(), is("test error"));
	}

	@Test
	void testSuccessToString() {
		CommandResult target = CommandResult.success("test ok");

		assertThat(target.toString(), is("SUCCESS: test ok"));
	}

	@Test
	void testErrorToString() {
		CommandResult target = CommandResult.error("test error");

		assertThat(target.toString(), is("ERROR: test error"));
	}

}