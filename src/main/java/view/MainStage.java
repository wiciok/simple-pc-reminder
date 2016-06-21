package view;

import javafx.geometry.Pos;
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
import java.time.format.DateTimeFormatter;

/**
 * podstawowa klasa od GUI
 * Stage głównego okna programu
 */

public class MainStage extends Application
{
	public Stage mainStage;
	private Database database;
	public MainStageController controller;

	@Override
	public void start(Stage primaryStage)
	{
		BorderPane root;

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
		Scheduler.init();

		try
		{
			this.mainStage=primaryStage;
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainStage.class.getResource("mainStage.fxml"));
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

		//-----------------konfiguracja kontrolek-------------------------------------------

		controller.buttonClose.setText(Resources.MainStageRes.buttonCloseText);
		controller.buttonAdd.setText(Resources.MainStageRes.buttonAddText);
		controller.buttonPrevEvents.setText(Resources.MainStageRes.buttonPrevEventsText);
		controller.buttonNextEvents.setText(Resources.MainStageRes.buttonNextEventsText);
		controller.buttonRefresh.setText(Resources.MainStageRes.buttonRefreshText);
		controller.pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));

		controller.paneEvent1.setText(Scheduler.taskDisplayList.get(0).getTitle());
		controller.paneEvent2.setText(Scheduler.taskDisplayList.get(1).getTitle());
		controller.paneEvent3.setText(Scheduler.taskDisplayList.get(2).getTitle());

        /*LABELE OGOLNE*/
		controller.descriptionLabel1.setText(Resources.MainStageRes.descriptionLabelText);
		controller.categoryLabel1.setText(Resources.MainStageRes.categoryLabelText);
		controller.titleLabel1.setText(Resources.MainStageRes.titleLabelText);
		controller.startDateTime1.setText(Resources.MainStageRes.startDateTimeText);
		controller.endDateTime1.setText(Resources.MainStageRes.endDateTimeText);
		controller.alertFrequency1.setText(Resources.MainStageRes.alertFrequencyText);
		controller.priority1.setText(Resources.MainStageRes.priorityText);
		controller.isActive1.setText(Resources.MainStageRes.isActiveText);

		controller.descriptionLabel2.setText(Resources.MainStageRes.descriptionLabelText);
		controller.categoryLabel2.setText(Resources.MainStageRes.categoryLabelText);
		controller.titleLabel2.setText(Resources.MainStageRes.titleLabelText);
		controller.startDateTime2.setText(Resources.MainStageRes.startDateTimeText);
		controller.endDateTime2.setText(Resources.MainStageRes.endDateTimeText);
		controller.alertFrequency2.setText(Resources.MainStageRes.alertFrequencyText);
		controller.priority2.setText(Resources.MainStageRes.priorityText);
		controller.isActive2.setText(Resources.MainStageRes.isActiveText);

		controller.descriptionLabel3.setText(Resources.MainStageRes.descriptionLabelText);
		controller.categoryLabel3.setText(Resources.MainStageRes.categoryLabelText);
		controller.titleLabel3.setText(Resources.MainStageRes.titleLabelText);
		controller.startDateTime3.setText(Resources.MainStageRes.startDateTimeText);
		controller.endDateTime3.setText(Resources.MainStageRes.endDateTimeText);
		controller.alertFrequency3.setText(Resources.MainStageRes.alertFrequencyText);
		controller.priority3.setText(Resources.MainStageRes.priorityText);
		controller.isActive3.setText(Resources.MainStageRes.isActiveText);

        /*LABELE SZCZEGOLOWE*/
		controller.labelEvent1IsActive.setText(String.valueOf(Scheduler.taskDisplayList.get(0).getIsActive()));
		controller.labelEvent1Priority.setText(Integer.toString(Scheduler.taskDisplayList.get(0).getPriority()));
		controller.labelEvent1AlertFrequency.setText(Integer.toString(Scheduler.taskDisplayList.get(0).getAlertFrequency()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		controller.labelEvent1StartDateTime.setText(Scheduler.taskDisplayList.get(0).getEventFullDateStart().format(formatter));
		controller.labelEvent1EndDateTime.setText(Scheduler.taskDisplayList.get(0).getEventFullDateEnd().format(formatter));
		controller.labelEvent1Title.setText(Scheduler.taskDisplayList.get(0).getTitle());
		controller.labelEvent1Category.setText(Scheduler.taskDisplayList.get(0).getCategory());
		controller.labelEvent1Description.setAlignment(Pos.TOP_LEFT);
		controller.labelEvent1Description.setWrapText(true);
		controller.labelEvent1Description.setText(Scheduler.taskDisplayList.get(0).getDescription());

		controller.labelEvent2IsActive.setText(String.valueOf(Scheduler.taskDisplayList.get(1).getIsActive()));
		controller.labelEvent2Priority.setText(Integer.toString(Scheduler.taskDisplayList.get(1).getPriority()));
		controller.labelEvent2AlertFrequency.setText(Integer.toString(Scheduler.taskDisplayList.get(1).getAlertFrequency()));
		controller.labelEvent2StartDateTime.setText(Scheduler.taskDisplayList.get(1).getEventFullDateStart().format(formatter));
		controller.labelEvent2EndDateTime.setText(Scheduler.taskDisplayList.get(1).getEventFullDateEnd().format(formatter));
		controller.labelEvent2Title.setText(Scheduler.taskDisplayList.get(1).getTitle());
		controller.labelEvent2Category.setText(Scheduler.taskDisplayList.get(1).getCategory());
		controller.labelEvent2Description.setAlignment(Pos.TOP_LEFT);
		controller.labelEvent2Description.setWrapText(true);
		controller.labelEvent2Description.setText(Scheduler.taskDisplayList.get(1).getDescription());

		controller.labelEvent3IsActive.setText(String.valueOf(Scheduler.taskDisplayList.get(2).getIsActive()));
		controller.labelEvent3Priority.setText(Integer.toString(Scheduler.taskDisplayList.get(2).getPriority()));
		controller.labelEvent3AlertFrequency.setText(Integer.toString(Scheduler.taskDisplayList.get(2).getAlertFrequency()));
		controller.labelEvent3StartDateTime.setText(Scheduler.taskDisplayList.get(2).getEventFullDateStart().format(formatter));
		controller.labelEvent3EndDateTime.setText(Scheduler.taskDisplayList.get(2).getEventFullDateEnd().format(formatter));
		controller.labelEvent3Title.setText(Scheduler.taskDisplayList.get(2).getTitle());
		controller.labelEvent3Category.setText(Scheduler.taskDisplayList.get(2).getCategory());
		controller.labelEvent3Description.setAlignment(Pos.TOP_LEFT);
		controller.labelEvent3Description.setWrapText(true);
		controller.labelEvent3Description.setText(Scheduler.taskDisplayList.get(2).getDescription());

		controller.buttonRemove1.setText(Resources.MainStageRes.buttonRemoveText);
		controller.buttonRemove2.setText(Resources.MainStageRes.buttonRemoveText);
		controller.buttonRemove3.setText(Resources.MainStageRes.buttonRemoveText);

		//-----------------------------------------------------------------------------------------------------
	}

	public static void main(String[] args) {launch(args);}

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


