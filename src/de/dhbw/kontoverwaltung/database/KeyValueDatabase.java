package de.dhbw.kontoverwaltung.database;

public interface KeyValueDatabase<T> {

	public T getFromKey(String key);

	public void setWithKey(String key, T object);

}
