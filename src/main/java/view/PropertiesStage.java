package view;

import controller.PropertiesStageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Paweł on 2016-06-19.
 *
 * Klasa zawierająca widok okna konfiguracji przypomnień.
 */

public class PropertiesStage
{
	public MainStage mainApp;
    public Stage propertiesStage;
    private PropertiesStageController controller;
    
    public PropertiesStage(MainStage mainApp)
    {
        AnchorPane root;
        this.mainApp=mainApp;
        try
        {
            propertiesStage=new Stage();
            propertiesStage.setResizable(false);

            FXMLLoader propertiesLoader = new FXMLLoader();
            propertiesLoader.setLocation(PropertiesStage.class.getResource("propertiesStage.fxml"));
            root = propertiesLoader.load();

            Scene scene = new Scene(root);
            propertiesStage.setScene(scene);
            propertiesStage.setTitle("Properties");
            propertiesStage.show();

            controller = propertiesLoader.getController();
            controller.setMainApp(this);
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Properties Stage Error!");
            alert.setContentText("Stage will be closed.");

            alert.showAndWait();
            propertiesStage.close();
        }
        ObservableList<Integer> howManyHoursOptions = FXCollections.observableArrayList(1,2,3,4,5);
        ObservableList<String> activeOptions = FXCollections.observableArrayList(Resources.AddEventStageRes.strTrue, Resources.AddEventStageRes.strFalse);
        
        controller.howManyHoursLabel.setText(Resources.PropertiesStageRes.howManyHoursLabelText);
        controller.isActiveLabel.setText(Resources.PropertiesStageRes.isActiveLabelText);
        
        controller.exitButton.setText(Resources.PropertiesStageRes.exitButtonText);
        controller.saveButton.setText(Resources.PropertiesStageRes.saveButtonText);
        
        controller.howManyHours.setItems(howManyHoursOptions);
        controller.howManyHours.getSelectionModel().selectFirst();
        
        controller.isActive.setItems(activeOptions);
        controller.isActive.getSelectionModel().selectFirst();
    }
}
