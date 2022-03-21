package de.dhbw.kontoverwaltung.terminal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

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

	@Test
	void testPossibilities() {
		CommandResult target = CommandResult.usage("BANK", Stream.of("DELETE", "CREATE").collect(Collectors.toSet()));
		assertThat(target.toString(), is("ERROR: incomplete command: BANK <DELETE|CREATE>"));
	}

	@Test
	void testPossibilitiesStart() {
		CommandResult target = CommandResult.usage("", Stream.of("BANK", "KUNDE").collect(Collectors.toSet()));
		assertThat(target.toString(), is("ERROR: incomplete command: <BANK|KUNDE>"));
	}

	@Test
	void testMultiInput() {
		CommandResult target = CommandResult.usage("BANK CREATE", Arrays.asList("name", "id"));
		assertThat(target.toString(), is("ERROR: incomplete command: BANK CREATE <name> <id>"));
	}

}