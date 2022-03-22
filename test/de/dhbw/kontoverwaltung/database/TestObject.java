package de.dhbw.kontoverwaltung.database;

import java.io.Serializable;

class TestObject implements Serializable {

	private String testString;
	private int testInt;

	public String getTestString() {
		return testString;
	}

	public int getTestInt() {
		return testInt;
	}

	public TestObject(String testString, int testInt) {
		super();
		this.testString = testString;
		this.testInt = testInt;
	}

}
