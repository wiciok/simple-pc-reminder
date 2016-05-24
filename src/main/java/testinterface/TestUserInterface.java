package testinterface;

import java.io.IOException;
import java.util.Scanner;

import data.Database;
import logic.event.Event;

/**
 * Created by Witek on 2016-05-22.
 * tutaj bedzie tymczasowy tekstowy interfejs do testowania logiki programu
 */
public class TestUserInterface
{

	public void interfaceMenu()
	{
		System.out.println("1 - Input new event.");
		System.out.println("2 - Display all events.");
		System.out.println("3 - Save events into binary file.");
		System.out.println("4 - Read events from binary file.");
		System.out.println("5 - Show number of current events.");
		System.out.println("6 - Close the program.");				
	}
	
	public static void main(String[] args)
    {
    	int var;
    	Integer addOption, index;
    	boolean inputStatus = false;
    	TestUserInterface testObj = new TestUserInterface();
    	Database testDatabase = new Database();
    	Scanner input = new Scanner(System.in);
    	while(true)
    	{
    		testObj.interfaceMenu();
    		var = input.nextInt();
    		switch(var)
			{			
				case 1:	while(inputStatus == false)
						{
							System.out.println("Press 1 to input new event to the end of a list.");
							System.out.println("Press 2 to choose where to place new event.");
							addOption = input.nextInt();
							if(addOption == 1)
							{
									testDatabase.addToList(new Event(), addOption, null);
									inputStatus = true;
							}
							else if(addOption == 2)
							{
								System.out.println("Input where to insert new event in the list.");
								while((index = input.nextInt()) > testDatabase.returnSize())
								{
									System.out.println("You cannot insert new event there");
									System.out.println("Choose from 0-"+testDatabase.returnSize());
								}
								testDatabase.addToList(new Event(), addOption, index);
								inputStatus = true;
							}
							else
							{
								System.out.println("Wrong number (input 1 or 2)!");
								inputStatus = false;
								continue;
							}
						}
						System.out.println("New event has been added to the end of the list!");
						inputStatus = false;
						break;
						
						
				case 2: testDatabase.displayEventList();
						break;
				case 3: try 
						{
							testDatabase.writeToFile();
						}
						catch (IOException e)
						{
							System.out.println("Error writing to file (TestUserInterface main)");
							e.printStackTrace();
						}
						break;
						
				case 4: try
						{
							testDatabase.readFromFile();
						}
						catch (IOException e)
						{
							System.out.println("Error reading from file (TestUserInterface main)");
							e.printStackTrace();
						}
						break;
						
				case 5: System.out.println("List size:"+testDatabase.returnSize());
						break;
				case 6: System.out.println("KONIEC");
						input.close();
						System.exit(0);
						break;
				default: System.out.println("Wrong number!\n");
				 		 inputStatus = false;
			}
    	}
    	
    }

}
