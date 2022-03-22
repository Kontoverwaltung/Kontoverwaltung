package de.dhbw.kontoverwaltung.database;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class PersistentDatabase<T extends Serializable> implements KeyValueDatabase<T> {

	private static final String SEPERATOR = ";";

	private ObjectSerializer<T> objectSerializer = new ObjectSerializer<>();
	private FileHandler fileHandler;

	public PersistentDatabase(FileHandler fileWriter) {
		super();
		this.fileHandler = fileWriter;
	}

	@Override
	public T get(String key) {
		try {
			List<String> list = fileHandler.readAllLines();

			for (String line : list) {
				String[] split = line.split(SEPERATOR);
				String currentKey = split[0];
				if (currentKey.equals(key)) {
					String value = split[1];
					return objectSerializer.deserialize(value);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void set(String key, T object) {
		String toWrite = createLine(key, object);
		if (fileHandler.contains(toWrite)) {
			fileHandler.deleteLine(toWrite);
		}
		fileHandler.appendLine(toWrite);
	}

	@Override
	public T remove(String key) {
		T object = get(key);
		if (object != null) {
			fileHandler.deleteLine(createLine(key, object));
			return object;
		}
		return null;
	}

	private String createLine(String key, T object) {
		try {
			return key + SEPERATOR + objectSerializer.serialize(object);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
