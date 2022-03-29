package de.dhbw.kontoverwaltung.terminal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import de.dhbw.kontoverwaltung.terminal.command.results.CommandResult;

class CommandResultTest {

	private static final String TEST_OK = "test ok";
	private static final String TEST_ERROR = "test error";
	
	private static final String ERROR_INCOMPLETE_COMMAND = "ERROR: incomplete command: ";
	
	private CommandResult targetError = CommandResult.error(TEST_ERROR);
	private CommandResult targetOk = CommandResult.success(TEST_OK);

	@Test
	void testSuccessData() {
		assertThat(targetOk.isSuccessful(), is(true));
		assertThat(targetOk.getAdditionalInfo(), is(TEST_OK));
	}

	@Test
	void testErrorData() {
		assertThat(targetError.isSuccessful(), is(false));
		assertThat(targetError.getAdditionalInfo(), is(TEST_ERROR));
	}

	@Test
	void testSuccessToString() {
		assertThat(targetOk.toString(), is("SUCCESS: " + TEST_OK));
	}

	@Test
	void testErrorToString() {
		assertThat(targetError.toString(), is("ERROR: " + TEST_ERROR));
	}

	@Test
	void testPossibilities() {
		CommandResult target = CommandResult.usage("BANK", Stream.of("DELETE", "CREATE").collect(Collectors.toSet()));
		assertThat(target.toString(), is("BANK <DELETE|CREATE>"));
	}

	@Test
	void testPossibilitiesStart() {
		CommandResult target = CommandResult.usage("", Stream.of("BANK", "KUNDE").collect(Collectors.toSet()));
		assertThat(target.toString(), is(ERROR_INCOMPLETE_COMMAND + "<BANK|KUNDE>"));
	}

	@Test
	void testMultiInput() {
		CommandResult target = CommandResult.usage("BANK CREATE", Arrays.asList("name", "id"));
		assertThat(target.toString(), is(ERROR_INCOMPLETE_COMMAND + "BANK CREATE <name> <id>"));
	}

}