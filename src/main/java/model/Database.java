package model;

import model.event.Event;
import model.event.EventSerializable;

import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.IndexOutOfBoundsException;

/**
 * @author Paweł Kapuśniak
 * @author Witold Karaś
 * Klasa ktorej zadaniem jest obsluga bazy wydarzeń.
 */

public class Database
{
	private ArrayList<Event> databaseList = new ArrayList<> ();

	/*Singleton*/
	private static Database mainObject = new Database();
	private Database(){}
	public static Database getInstance() {return mainObject;}

	public void add(Integer index, Event newEvent) {databaseList.add(index, newEvent);}
	public void add(Event newEvent) {databaseList.add(newEvent);}
	public void remove(int index) throws IndexOutOfBoundsException {databaseList.remove(index);}
	int size() {return databaseList.size();}
	Event get() {return databaseList.get(0);}
	Event get(int index) throws IndexOutOfBoundsException {return databaseList.get(index);}

	/**
	 * writeToFile - zapis do pliku binarnego
	 * wykonuje translację pomiędzy klasami Event i EventSerializable
	 * @throws IOException
	 * */
	public void writeToFile() throws IOException
	{
		String filePath = "binaryFile.dat";
		ObjectOutputStream file;

		try {file = new ObjectOutputStream(new FileOutputStream(filePath));}
		catch (FileNotFoundException e) {throw new IOException(e.getCause());}

		file.writeInt(databaseList.size()); //zapis ilości rekordów

		for(int i = 0; i<databaseList.size(); ++i)
			file.writeObject(new EventSerializable(databaseList.get(i)));
		file.close();
	}
	
	/**
	 * readFromFile - odczyt z pliku binarnego.
	 * wykonuje translację pomiędzy klasami Event i EventSerializable
	 * @throws IOException
	**/
	public void readFromFile() throws IOException
	{
		String filePath = "binaryFile.dat";
		ObjectInputStream file;

		try {file = new ObjectInputStream(new FileInputStream(filePath));}
		catch (FileNotFoundException e) {throw new IOException(e.getCause());}

		//odczytanie ilości rekordów
		final int size = file.readInt();

		ArrayList<Event> tmp = new ArrayList<>();
		for(int i = 0; i<size; i++)
		{
			try {tmp.add(new Event((EventSerializable)file.readObject()));}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
				throw new IOException(e.getCause());
			}
		}
		databaseList.clear();
		databaseList.addAll(tmp);
		file.close();
	}

	void sort() throws IndexOutOfBoundsException
	{
		if(databaseList.size() <= 1)
			throw new IndexOutOfBoundsException();
		databaseList.sort((event1, event2) -> event1.getEventFullDateStart().compareTo(event2.getEventFullDateStart()));
	}
}
