package de.dhbw.kontoverwaltung.database;

import java.util.HashMap;

public class OnlyMemoryDatabase<T> implements KeyValueDatabase<T> {

	private HashMap<String, T> storage = new HashMap<String, T>();

	@Override
	public T get(String key) {
		return storage.get(key);
	}

	@Override
	public void set(String key, T object) {
		storage.put(key, object);
	}

	@Override
	public void remove(String key) {
		storage.remove(key);
	}

}
