package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Database;
import view.AddEventStage;
import view.PropertiesStage;

public class PropertiesStageController implements Initializable
{
	private PropertiesStage propertiesStage;
	
	public void setMainApp(PropertiesStage PropertiesStage)
    {
        this.propertiesStage = PropertiesStage;
    }
	
	@FXML public Button exitButton;
	@FXML public Button saveButton;
	@FXML public Label howManyHoursLabel;
	@FXML public Label howManyDaysLabel;
	@FXML public ComboBox<Integer> howManyHours;
	@FXML public ComboBox<Integer> howManyDays;
	
	public void initialize(URL url, ResourceBundle rb)
    {
		exitButton.setOnAction(event -> propertiesStage.propertiesStage.close());
		saveButton.setOnAction(event -> 
		{
			for(int i = 0; i<Database.getInstance().size(); i++)
				Database.getInstance().get(i).setAlertFrequency(howManyHours.getSelectionModel().getSelectedItem());
			propertiesStage.propertiesStage.close();

		});
    }
}
