/**
 * podstawowa klasa od GUI - na razie nie ruszamy
 */


package application;
	
import java.io.IOException;

import data.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
		
		Database testDatabase = new Database();
		testDatabase.addToList(new Event());
		testDatabase.addToList(new Event());
		testDatabase.addToList(new Event());
		testDatabase.addToList(new Event());
		
		System.out.println("List size after adding events:"+testDatabase.returnSize());
		
		try
		{
			testDatabase.writeToFile();
		}
		catch (IOException e)
		{
			System.out.println("Error writing to file: IOException (try/catch block in main)");
			e.printStackTrace();
		}
		
		try
		{
			testDatabase.readFromFile();
		}
		catch (IOException e)
		{
			System.out.println("Error reading from file: IOException (try/catch block in main)");
			e.printStackTrace();
		}
	}
}
