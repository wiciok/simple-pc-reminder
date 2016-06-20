package view;

import model.Database;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Scheduler;
import javafx.scene.layout.*;
import controller.MainStageController;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;

/**
 * podstawowa klasa od GUI
 * Stage głównego okna programu
 */


public class MainStage extends Application
{
	public Stage mainStage;
	private BorderPane root;
	private Database database;
	//ToDo: to public to tak średnio bym powiedział
	public MainStageController controller;

	@Override
	public void start(Stage primaryStage)
	{
		database = Database.getInstance(); //użycie wzorca Singleton


		try {database.readFromFile();}
		catch(IOException e)
		{
			//e.printStackTrace();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Database File hasn't been read.");

			alert.showAndWait();
		}


		//todo: usunac potem (jest dla testow narazie):
		//Event test1 = new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test1", "test1 opis", "kat test", 5, true, 5);
		//Event test2=new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test2", "test2 opis", "kat test2", 2, true, 10);
		//Event test3=new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test3", "test3 opis", "kat test3", 2, true, 10);

		//database.add(test3);
		//database.add(test2);
		//database.add(test1);

		Scheduler.init();

		try
		{
			this.mainStage=primaryStage;
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainStage.class.getResource("mainStage.fxml"));;
			root = loader.load();

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Simple PC Reminder");
			primaryStage.show();

			controller = loader.getController();
			controller.setMainApp(this);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Stage Error!");
			alert.setContentText("Application will be terminated.");

			alert.showAndWait();
			primaryStage.close();
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
		}
		catch (IOException e)
		{
			//e.printStackTrace();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText(null);
			alert.setContentText("File has not been written on disc!");
			alert.showAndWait();
		}
	}

}

