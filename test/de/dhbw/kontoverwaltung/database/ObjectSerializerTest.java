package de.dhbw.kontoverwaltung.database;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ObjectSerializerTest {

	private ObjectSerializer<TestObject> target = new ObjectSerializer<TestObject>();

	@Test
	void test() throws IOException, ClassNotFoundException {
		TestObject testObject = new TestObject("testString", -99);

		String toString = target.serialize(testObject);
		TestObject newTestObject = target.deserialize(toString);

		assertThat(testObject.getTestInt(), is(newTestObject.getTestInt()));
		assertThat(testObject.getTestString(), is(newTestObject.getTestString()));
	}

}
