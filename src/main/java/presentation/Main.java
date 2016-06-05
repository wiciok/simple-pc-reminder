/**
 * podstawowa klasa od GUI
 */

package presentation;

import data.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.event.Event;
import javafx.scene.layout.*;

import java.time.LocalDate;
import java.time.LocalTime;


public class Main extends Application
{
	Stage primaryStage;
	Stage b;

	public void init()
	{
		Database database = new Database();


		Event test1 = new Event(LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(),"test1", "test1 opis", "kat test", 5, true, 5);
		Event test2=new Event(test1);

		database.add(test1);
		database.add(test2);

	}

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			this.primaryStage=primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("primaryStage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Simple PC Reminder");
			primaryStage.show();



			GridPane r2=new GridPane();
			Scene scene2 = new Scene(r2, 400, 400);
			b=new Stage();
			b.setScene(scene2);


			b.show();
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
}
