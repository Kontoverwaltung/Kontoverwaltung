package de.dhbw.kontoverwaltung.types;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

class PinTest {

	private Pin target = new Pin("22tUzX");

	@Test
	void testWrongPin() {
		assertThat(target.checkPin("bGs22Ax"), is(false));
	}

	@Test
	void testCorrectPin() {
		assertThat(target.checkPin("22tUzX"), is(true));
	}

}
