package data;

import logic.event.*;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Implemented by Pawel
 *
 *Na wstepie: klasa Event implementuje interfejs Serializable - jest to potrzebne do
 *zapisu i odczytu binarnego do/z pliku i nie wiem jak to robic bez tego (i czy sie da bez tego)
 *wiec nie usuwajcie tego jak mozecie :D
 *
 *Klasa oktora jest warstwa logiczna. Jej zadaniem jest obsluga bazy wydarzen.
 *Narazie ma 5 metod: addToList, displayEventList, writeToFile, readFromFile, returnSize 
 *i liste z wydarzeniami: databaseList. Opisy poszczegolnych funkcji przy deklaracji.
 *
 *TODO: OGARNAC JAK SPRAWDZAC W PLIKU ILE JEST ZAPISANYCH OBIEKTOW
 *		ZEBY TEJ TABLICY NIE MUSIEC CIAGLE SZTYWNO ZMIENIAC W KODZIE (readFromFile)
 * 
 * 		WYSWIETLANIE LISTY - MUSI BYC COS W KLASIE EVENT
 *
 */

public class Database
{
	private ArrayList<Event> databaseList = new ArrayList<Event> ();
	
/**
 *addToList - metoda pozwalajaca do dodawania elementow do listy wydarzen (databaseList)
 *uzytkownik moze dodac na koniec listy lub wybrac sobie miejsce na ktore chce wstawic
 *Zalezy co zostale wybrane w menu - jesli 1 to event jest dodany na koniec,
 *jesli 2 to wevent jest dodany na miejsce wskazane przez uzytkownika (o ile zostanie zachowana ciaglosc listy)
 **/
	public void addToList(Event newEvent, Integer addOption, Integer index)
	{
		if(index == null)
			index = databaseList.size();
		
		switch(addOption)
		{
			case 1:	databaseList.add(newEvent);
					break;
						
			case 2: databaseList.add(index, newEvent);
					break;
		}
	}
	
	/**
	*displayEventList - metoda wyswietlajaca wydarzenia - widze to tak ze tez uzytkownik moze sobie wyswietlic 1 wydarzenie, wszystkie, lub jakies konkretne
	*ale do tego w klasie Event musi juz cos byc(przede wszystkim jakas funkcja wyswietlajaca wydarzenie ktora tu wywolam)
	**/
	public void displayEventList()
	{
		for(int i =0; i<databaseList.size(); i++)
		{
			//TODO:
			//databaseList.get(i).jakasFunkcjaWypisujacaEvent;
			
			//zeby wyswietlac te wydarzenia w klasie Event musi byc jakas funkcja je wyswietlajaca
			//i tu ja bedziemy wywolywac. Narazie jej nie ma wiec to zostawiam.
		}
	}
	/**
	*returnSize - zwraca ilosc wydarzen, taka funkcja zawsze sie przydaje w mainie - lista jest private
	**/
	public int returnSize()
	{
		return databaseList.size();
	}
	
	/**
	*writeToFile - zapis do pliku binarnego
	* @throws IOException
	* sciezka wzgledna - tworzy plik binaryFile.dat w folderze projektu
	**/
	public void writeToFile() throws IOException
	{
		String filePath = "binaryFile.dat";
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream(new FileOutputStream(filePath));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error File not found (writeToFile)");
			e.printStackTrace();
		}

		for(int i = 0; i<databaseList.size(); ++i)
		{
			oos.writeObject(databaseList.get(i));
		}
		oos.close();
	}
	
	/**
	* readFromFile - odczyt z pliku binarnego.
	* TODO jest opisane w funckji
	* @throws IOException
	**/
	public void readFromFile() throws IOException
	{
		int i;
		String filePath = "binaryFile.dat";
		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream(new FileInputStream(filePath));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error File not found (readFromFile)");
			e.printStackTrace();
		}
		//TODO: OGARNAC JAK SPRAWDZAC W PLIKU ILE JEST ZAPISANYCH OBIEKTOW
		//ZEBY TEJ TABLICY NIE MUSIEC CIAGLE SZTYWNO ZMIENIAC W KODZIE
		Event[] tmp = new Event[databaseList.size()];
		
		for(i = 0; i<tmp.length; i++) 
		{
			try
			{
				tmp[i] = (Event) ois.readObject();
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Error Class not found (readFromFile)");
				e.printStackTrace();
			}
			System.out.println(tmp[i].pole);
		}
		ois.close();
	}
}
