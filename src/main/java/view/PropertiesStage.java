package view;

import controller.PropertiesStageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    }
}
