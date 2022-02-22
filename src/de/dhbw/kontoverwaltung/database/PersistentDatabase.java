package de.dhbw.kontoverwaltung.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PersistentDatabase<T> implements KeyValueDatabase<T>  {

	private final String DATABASEFILENAME;
	
	public PersistentDatabase(String databaseFileName) {
		super();
		DATABASEFILENAME = databaseFileName;
	}

	@Override
	public T get(String key) {
		HashMap<String, T> records = new HashMap<String, T>();
		try (BufferedReader br = new BufferedReader(new FileReader(DATABASEFILENAME))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] record = line.split(";");
				records.put(record[0], (T) record[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return records.get(key);
	}

	@Override
	public void set(String key, T object) {
		try (FileWriter csvWriter = new FileWriter(DATABASEFILENAME, true)) {
			csvWriter.write(key + ';' + object.toString());
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
