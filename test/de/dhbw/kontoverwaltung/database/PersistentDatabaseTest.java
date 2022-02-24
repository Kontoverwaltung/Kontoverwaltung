package de.dhbw.kontoverwaltung.database;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersistentDatabaseTest {

	private PersistentDatabase<TestObject> target;

	@BeforeEach
	public void reset() {
		target = new PersistentDatabase<TestObject>(new FileHandlerMock());
//		target = new PersistentDatabase<TestObject>(new FileHandlerImpl("test.csv"));
	}

	@Test
	void testOneElement() {
		assertNull(target.get("key"));

		target.set("key", new TestObject("testString", 152));
		TestObject result = target.get("key");
		assertThat(result.getTestInt(), is(152));
		assertThat(result.getTestString(), is("testString"));

		target.remove("key");
		assertNull(target.get("key"));
	}

	@Test
	void testMultipleElements() {
		assertNull(target.get("key1"));
		target.set("key1", new TestObject("obj1", 1));

		assertNull(target.get("key2"));
		target.set("key2", new TestObject("obj2", 2));

		assertNull(target.get("key3"));
		target.set("key3", new TestObject("obj3", 3));

		TestObject result1 = target.get("key1");
		assertThat(result1.getTestInt(), is(1));
		assertThat(result1.getTestString(), is("obj1"));

		TestObject result2 = target.get("key2");
		assertThat(result2.getTestInt(), is(2));
		assertThat(result2.getTestString(), is("obj2"));

		TestObject result3 = target.get("key3");
		assertThat(result3.getTestInt(), is(3));
		assertThat(result3.getTestString(), is("obj3"));

		target.remove("key1");
		assertNull(target.get("key1"));

		target.remove("key2");
		assertNull(target.get("key2"));

		target.remove("key3");
		assertNull(target.get("key3"));
	}

}
