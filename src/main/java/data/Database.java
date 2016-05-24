package data;

import logic.event.*;

import java.util.ArrayList;
import java.util.Scanner;
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
 *Klasa narazie ma 5 metody: addToList, displayEventList, writeToFile, readFromFile, returnSize 
 *i liste z wydarzeniami: databaseList
 *
 *addToList - metoda pozwalajaca do dodawania elementow do listy wydarzen (databaseList)
 *uzytkownik moze dodac na koniec listy lub wybrac sobie miejsce na ktore chce wstawic(zalezy co wybierze)
 *
 *displayEventList - metoda wyswietlajaca wydarzenia - widze to tak ze tez uzytkownik moze sobie wyswietlic 1 wydarzenie, wszystkie, lub jakies konkretne
 *ale do tego w klasie Event musi juz cos byc(przede wszystkim jakas funkcja wyswietlajaca wydarzenie ktora tu wywolam)
 *
 *writeToFile - zapis do pliku binarnego (jesli komus sciezka nie odpowiada to moze sobie zmienic - skoro i tak bedzie kazdy na swoim branchu pisal)
 *
 *readFromFile - odczyt z pliku binarnego. Tu jest problem. Ogolnie metoda dziala ale odczytuje tylko jeden obiekt.
 *Nie wiem jak odczytac wiecej - na necie nic narazie nie znalazlem, bedzie trzeba nad tym przysiasc jeszcze
 *
 *returnSize - zwraca ilosc wydarzen, taka funkcja zawsze sie przydaje, aktualnie dla sprawdzenia czy sie poprawnie wydarzenia dodaly
 *wywoluje ja w mainie po dodaniu wydarzen
 */

public class Database
{
	private ArrayList<Event> databaseList = new ArrayList<Event> ();
	
	public void addToList(Event newEvent)
	{
		boolean inputStatus = false;
		int var;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Press 1 to input new event on the end of the databaseList");
		System.out.println("Press 2 to select the place in databaseList for new event");
		while(inputStatus == false)
		{
			var = input.nextInt();
			switch(var)
			{
				case 1:	databaseList.add(newEvent);
						System.out.println("New event has been added to the end of the list!");
						inputStatus = true;
						break;
						
				case 2: System.out.println("Input where to insert new event in the list.");
						while((var = input.nextInt()) > databaseList.size())
						{
							System.out.println("You cannot insert new event there");
							System.out.println("Choose from 0-"+databaseList.size()+"");
						}
						databaseList.add(var, newEvent);
						System.out.println("New event has been added to the end of the list!");
						inputStatus = true;
						break;
						
				default: System.out.println("Wrong number (input 1 or 2)!");
						 inputStatus = false;
			}
		}
		input.close();
	}
	
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
	
	public int returnSize() //przydaje sie
	{
		return databaseList.size();
	}
	
	public void writeToFile() throws IOException
	{
		String filePath = "D:\\JavaProject\\binaryFile.dat";
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
	
	public void readFromFile() throws IOException
	{
		Event obj = null;
		String filePath = "D:\\JavaProject\\binaryFile.dat";
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
		//Event[] tmp = null;

		/*Wczytywanie z pliku do dopracowania - zczytuje tylko 1 obiekt
		  i nie wiem jak to naprawic*/
		
		try
		{
			obj = (Event) ois.readObject();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error Class not found (readFromFile)");
			e.printStackTrace();
		}
		System.out.println(obj.pole);
		
		/*for(i=0; i<3; i++) 
		{
			tmp[i] = (Event) ois.readObject();
		}
		
		for(i = 0; i<tmp.length; i++)
		{
			System.out.println(tmp[i].pole);
		}*/
		ois.close();
	}
}
