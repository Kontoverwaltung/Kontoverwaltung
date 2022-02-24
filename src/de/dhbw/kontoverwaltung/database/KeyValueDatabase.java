package de.dhbw.kontoverwaltung.database;

public interface KeyValueDatabase<T> {

	public T get(String key);
	public void set(String key, T object);
	public void remove(String key);

}
