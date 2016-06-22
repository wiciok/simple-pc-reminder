package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Database;
import view.PropertiesStage;

/**
 * Created by Paweł on 2016-06-19.
 *
 * Klasa zawierająca kontroler okna konfiguracji przypomnień.
 */

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
	@FXML public Label isActiveLabel;
	@FXML public ComboBox<Integer> howManyHours;
	@FXML public ComboBox<String> isActive;
	
	public void initialize(URL url, ResourceBundle rb)
    {
		exitButton.setOnAction(event -> propertiesStage.propertiesStage.close());
		saveButton.setOnAction(event -> 
		{
			for(int i = 0; i<Database.getInstance().size(); i++)
				Database.getInstance().get(i).setAlertFrequency(howManyHours.getSelectionModel().getSelectedItem());
			
			for(int i = 0; i<Database.getInstance().size(); i++)
				Database.getInstance().get(i).setIsActive((Boolean.parseBoolean(isActive.getSelectionModel().getSelectedItem())));
			
			propertiesStage.propertiesStage.close();
		});
    }
}