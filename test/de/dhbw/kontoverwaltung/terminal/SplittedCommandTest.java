package de.dhbw.kontoverwaltung.terminal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

class SplittedCommandTest {

	private SplittedCommand splittedCommand = new SplittedCommand("kunde delete 122 now", " ");

	@Test
	void testStringAt() {
		assertThat(splittedCommand.getStringAt(1), is("delete"));
		assertThat(splittedCommand.getStringAt(2), is("122"));
		assertThat(splittedCommand.getStringAt(3), is("now"));
	}

	@Test
	void testUppercase() {
		assertThat(splittedCommand.getStringUppercaseAt(0), is("KUNDE"));
	}

	@Test
	void testIntAt() {
		assertThat(splittedCommand.getIntAt(2), is(122));
	}

	@Test
	void testCommandUpToPos() {
		assertThat(splittedCommand.getCommandUpToPos(3), is("kunde delete 122"));
	}

}
