/**
 * podstawowa klasa od GUI
 * Stage głównego okna programu
 */

package view;

import model.Database;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Scheduler;
import javafx.scene.layout.*;
import controller.PrimaryStageController;
import java.io.IOException;


public class Main extends Application
{
	public Stage primaryStage;
	private BorderPane root;
	private Database database;

	public void init()
	{
		/*ZMIANA WYNIKIAJACA Z SINGLETON - WYWALONY KONSTRUKTOR*/
		database = Database.getInstance();


		try {database.readFromFile();}
		catch(IOException e)
		{
			//ToDo: sensowniej to zrobić...
			e.printStackTrace();
			System.out.print("_______nie otworzono pliku!");
		}


		//todo: usunac potem (jest dla testow narazie):
		//Event test1 = new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test1", "test1 opis", "kat test", 5, true, 5);
		//Event test2=new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test2", "test2 opis", "kat test2", 2, true, 10);
		//Event test3=new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test3", "test3 opis", "kat test3", 2, true, 10);

		//database.add(test3);
		//database.add(test2);
		//database.add(test1);

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

			PrimaryStageController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch(Exception e) {e.printStackTrace();}

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
			System.out.println("__________zapisano");
		}
		catch (IOException e)
		{
			//ToDo: dorobic obsluge wyjatku!
			e.printStackTrace();
			System.out.println("__________ nie zapisano!!!!!!!");
		}
	}

}


