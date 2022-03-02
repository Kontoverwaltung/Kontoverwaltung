package de.dhbw.kontoverwaltung.terminal;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SplittedCommandTest {

	@Test
	void test() {
		SplittedCommand splittedCommand = new SplittedCommand("kunde delete 122 now", " ");
		assertThat(splittedCommand.getStringUppercaseAt(0), is("KUNDE"));
		assertThat(splittedCommand.getStringAt(1), is("delete"));
		assertThat(splittedCommand.getStringAt(3), is("now"));

		assertThat(splittedCommand.getStringAt(2), is("122"));
		assertThat(splittedCommand.getIntAt(2), is(122));

		assertThrows(NumberFormatException.class, () -> {
			splittedCommand.getIntAt(1);
		});
		assertNull(splittedCommand.getStringAt(4));
		assertNull(splittedCommand.getStringUppercaseAt(4));
	}

}
