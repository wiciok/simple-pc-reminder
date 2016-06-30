package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.event.Event;
import view.PropertiesStage;

/**
 * @author Paweł Kapuśniak on 2016-06-19.
 * Klasa zawierająca kontroler okna konfiguracji przypomnień.
 */

public class PropertiesStageController implements Initializable
{
	private PropertiesStage propertiesStage;

	@FXML public Button exitButton;
	@FXML public Button saveButton;
	@FXML public Label titleLabel;
	@FXML public Label priorityLabel;
	@FXML public Label howManyHoursLabel;
	@FXML public Label isActiveLabel;
	@FXML public Label defaultName;
	@FXML public Label defaultCategory;
	@FXML public ComboBox<Integer> howManyHours;
	@FXML public ComboBox<String> isActive;
	@FXML public ComboBox<Integer> priority;
	@FXML public TextField eventCategory;
	@FXML public TextField eventNameField;

	public void setMainApp(PropertiesStage PropertiesStage) {this.propertiesStage = PropertiesStage;}
	public void initialize(URL url, ResourceBundle rb)
    {
		exitButton.setOnAction(event -> propertiesStage.propertiesStage.close());
		saveButton.setOnAction(event -> 
		{
				Event.defaultAlertFrequency = howManyHours.getSelectionModel().getSelectedItem();
				Event.defaultIsActive = isActive.getSelectionModel().getSelectedItem();
				Event.defaultPriority = priority.getSelectionModel().getSelectedItem();
				Event.defaultTitle = eventNameField.getText();
				Event.defaultCategory = eventCategory.getText();
			propertiesStage.propertiesStage.close();
		});
    }
}
