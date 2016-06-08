package data;

import logic.event.*;

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
 * Implemented by Pawel
 *Klasa ktora jest warstwa danych. Jej zadaniem jest obsluga bazy wydarzen.
 *
 *
 * */

public class Database
{
	private ArrayList<Event> databaseList = new ArrayList<Event> ();

	/*Singleton*/
	private static Database mainObject = new Database();
	private Database(){} //prywatny konstruktor
	public static Database getInstance()
	{
		return mainObject;
	}

	/**
	 *add - metoda pozwalajaca do dodawania elementow do listy wydarzen (databaseList)
	 *wywołuje metodę add składnika ArrayList<Event> databaseList</>
	 **/
	public void add(Integer index, Event newEvent)
	{
		databaseList.add(index, newEvent);
	}

	public void add(Event newEvent)
	{
		databaseList.add(newEvent);
	}

	/**
	*size - zwraca ilosc wydarzen, taka funkcja zawsze sie przydaje w mainie - lista jest private
	**/
	public int size()
	{
		return databaseList.size();
	}

	/**
	 * get - zwraca obiekt Event z bazy - pierwszy, lub o podanym indeksie
	 */

	public Event get()
	{
		return databaseList.get(0);
	}

	public Event get(int index)
	{
		return databaseList.get(index);
	}

	
	/**
	*writeToFile - zapis do pliku binarnego
	* @throws IOException
	* sciezka wzgledna - tworzy plik binaryFile.dat w folderze projektu
	**/
	public void writeToFile() throws IOException
	{
		String filePath = "binaryFile.dat";
		ObjectOutputStream file = null;
		try
		{
			file = new ObjectOutputStream(new FileOutputStream(filePath));
		}
		catch (FileNotFoundException e)
		{
			//System.out.println("Error File not found (writeToFile)");
			//e.printStackTrace();
			throw new IOException(e.getCause()); //przekazywanie wyjatku wyżej, do interfejsu użytkownika
		}

		file.writeInt(databaseList.size()); //zapis ilości rekordów

		for(int i = 0; i<databaseList.size(); ++i)
		{
			file.writeObject(databaseList.get(i));
		}
		file.close();
	}
	
	/**
	* readFromFile - odczyt z pliku binarnego.
	* @throws IOException
	**/
	public void readFromFile() throws IOException
	{
		int i;
		String filePath = "binaryFile.dat";
		ObjectInputStream file = null;
		try
		{
			file = new ObjectInputStream(new FileInputStream(filePath));
		}
		catch (FileNotFoundException e)
		{
			//System.out.println("Error File not found (readFromFile)");
			//e.printStackTrace();
			throw new IOException(e.getCause()); //przekazywanie wyjatku wyżej, do interfejsu użytkownika
		}


		final int size = file.readInt();
		ArrayList<Event> tmp = new ArrayList<Event> ();

		for(i = 0; i<size; i++)
		{
			try
			{
				tmp.add( (Event)file.readObject());
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Error Class not found (readFromFile)");
				e.printStackTrace();
				throw new IOException(e.getCause());
			}
		}

		databaseList.clear();
		databaseList=tmp;
		file.close();
	}

	public void listQuicksort() throws IndexOutOfBoundsException
	{
		if(databaseList.size() <= 1)
		{
			throw new IndexOutOfBoundsException();
			//return;
		}
		
		
		databaseList.sort(new Comparator<Event>()
		{
			public int compare(Event event1, Event event2)
			{
				return event1.getEventFullDateStart().compareTo(event2.getEventFullDateStart());
			}
		});
	}
}
