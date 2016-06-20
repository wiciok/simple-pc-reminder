package view;

import java.io.IOException;
import java.util.Scanner;
import model.Database;
import model.event.Event;

/**
 * Implemented by Pawel
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
		System.out.println("6 - Sort database (based on event start time)");
		System.out.println("7 - Close the program.");				
	}
	
	public static void main(String[] args)
    {
		/*************************MatiM test***************************************
		Event prototype = new Event();
		Event wydarzenie1 = (Event)prototype.clone();
		wydarzenie1.setEventDateStart(LocalDate.parse("2016-06-11"));
		wydarzenie1.setEventTimeStart(LocalTime.parse("14:23"));
		wydarzenie1.setDescription("OPISIK JAKIS");
		wydarzenie1.setPriority(3);
		System.out.println(wydarzenie1.getEventDateNow());
		System.out.println(wydarzenie1.getIsActive());
		System.out.println(wydarzenie1);
		System.out.println(wydarzenie1.getEventDateTimeStart());
		System.out.println(wydarzenie1.getEventDateTimeEnd());
		/************************MatiM koniec testu********************************/
    	int var;
    	Integer addOption, index;
    	boolean inputStatus = false;
    	TestUserInterface testObj = new TestUserInterface();
    	Database testDatabase = Database.getInstance();
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
									testDatabase.add(new Event());
									inputStatus = true;
							}
							else if(addOption == 2)
							{
								System.out.println("Input where to insert new event in the list.");
								while((index = input.nextInt()) > testDatabase.size())
								{
									System.out.println("You cannot insert new event there");
									System.out.println("Choose from 0-"+testDatabase.size());
								}
								testDatabase.add(index, new Event());
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

				case 2:	for (int i=0;i<testDatabase.size();i++)
							System.out.println(testDatabase.get(i).toString());
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
						
				case 5: System.out.println("List size:"+testDatabase.size());
						break;
				case 6: //testDatabase.sort(0, testDatabase.size() - 1); //dodalem odpowiednie przeciazenie bezposrednio w Database
						testDatabase.sort();
						break;
				case 7: System.out.println("KONIEC");
						input.close();
						System.exit(0);
						break;
				default: System.out.println("Wrong number!\n");
				 		 inputStatus = false;
			}
    	}
    	
    }

}