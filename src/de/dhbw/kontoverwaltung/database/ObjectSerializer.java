package de.dhbw.kontoverwaltung.database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class ObjectSerializer<T extends Serializable> {

	public String serialize(T object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		oos.close();
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}

	public T deserialize(String string) throws IOException, ClassNotFoundException {
		byte[] data = Base64.getDecoder().decode(string);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		T object = (T) ois.readObject();
		ois.close();
		return object;
	}

}
