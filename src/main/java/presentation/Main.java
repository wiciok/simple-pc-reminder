/**
 * podstawowa klasa od GUI
 * Stage głównego okna programu
 */

package presentation;

import data.Database;
import javafx.application.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.event.Scheduler;
import logic.event.*;
import javafx.scene.layout.*;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;


public class Main extends Application
{
	Stage primaryStage;
	private BorderPane root;
	private Database database;

	public void init()
	{
		/*ZMIANA WYNIKIAJACA Z SINGLETON - WYWALONY KONSTRUKTOR*/
		database = Database.getInstance();

		/*try
		{
			database.readFromFile();
		}

		catch(IOException e)
		{
			//ToDo: sensowniej to zrobić...
			e.printStackTrace();
			System.out.print("_______nie otworzono pliku!");
		}*/

		//todo: usunac potem (jest dla testow narazie):
		//Event test1 = new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test1", "test1 opis", "kat test", 5, true, 5);
		//Event test2=new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test2", "test2 opis", "kat test2", 2, true, 10);
		//Event test3=new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test3", "test3 opis", "kat test3", 2, true, 10);


		//database.add(test3);
		//database.add(test2);
		//database.add(test1);

		//Scheduler.update();
		Scheduler.init();
	}



	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			this.primaryStage=primaryStage;
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("primaryStage.fxml"));
			root = loader.load();

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Simple PC Reminder");
			primaryStage.show();

			primaryStageController controller = loader.getController();
			controller.setMainApp(this);

			//toDo: usunac po tescie
			//Scheduler.update();
			Scheduler.taskDisplayList.get(0).titleProperty().addListener((observable, oldValue, newValue) -> controller.update1(newValue));
			Scheduler.taskDisplayList.get(1).titleProperty().addListener((observable, oldValue, newValue) -> controller.update2(newValue));
			Scheduler.taskDisplayList.get(2).titleProperty().addListener((observable, oldValue, newValue) -> controller.update3(newValue));
			//Scheduler.taskDisplayList.get(2).setTitle("fsdgasdg"); //tak nie zadziala
			//Scheduler.taskDisplayList.get(2).titleProperty().set("sfgvfadgw");
			//controller.test();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		launch(args);
	}


	/*@Override
	public void stop()
	{
		try
		{
			Database.getInstance().writeToFile();
			//todo: usunac potem:
			System.out.println("__________zapisano");
		}
		catch (IOException e)
		{
			//ToDo: dorobic obsluge wyjatku!
			e.printStackTrace();
			System.out.println("__________ nie zapisano!!!!!!!");
		}
	}*/

}


