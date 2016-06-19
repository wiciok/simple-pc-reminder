/**
 * podstawowa klasa od GUI
 * Stage głównego okna programu
 */

package presentation;

import data.Database;
import javafx.application.*;
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

		try
		{
			database.readFromFile();
		}

		catch(IOException e)
		{

		}
		//todo: usunac potem (jest dla testow narazie):
		/*Event test1 = new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test1", "test1 opis", "kat test", 5, true, 5);
		Event test2=new Event(test1);
		Event test3=new Event(test1);*/

		/*database.add(test1);
		database.add(test2);*/
		//database.add(test3);
		Scheduler.update();
	}

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			this.primaryStage=primaryStage;
			FXMLLoader loader = new FXMLLoader();
			//Parent root = loader.load(getClass().getResource("primaryStage.fxml"));
			loader.setLocation(Main.class.getResource("primaryStage.fxml"));
			root = loader.load();

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Simple PC Reminder");
			primaryStage.show();

			primaryStageController controller = loader.getController();
			controller.setMainApp(this);

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


	@Override
	public void stop()
	{
		try
		{
			Database.getInstance().writeToFile();
			//todo: usunac potem:
			System.out.println("zapisano");
		}
		catch (IOException e)
		{
			//ToDo: dorobic obsluge wyjatku!
		}
	}

}


