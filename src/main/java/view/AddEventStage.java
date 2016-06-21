package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import controller.AddEventStageController;

/**
 * Created by Witek on 2016-06-15.
 * Klasa dodatkowego okna od dodawania nowego wydarzenia.
 */
public class AddEventStage
{
    public MainStage mainApp;
    public Stage addEventStage;
    private AnchorPane root;

    public AddEventStage(MainStage mainApp)
    {
        this.mainApp=mainApp;

        try
        {
            addEventStage=new Stage();

            FXMLLoader addEventLoader = new FXMLLoader();
            addEventLoader.setLocation(AddEventStage.class.getResource("addEventStage.fxml"));
            root = addEventLoader.load();

            Scene scene = new Scene(root);
            addEventStage.setScene(scene);
            addEventStage.setTitle("Add New Event");
            addEventStage.show();

            AddEventStageController controller = addEventLoader.getController();
            controller.setMainApp(this);
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Stage Error!");
            alert.setContentText("Stage will be closed.");

            alert.showAndWait();
            addEventStage.close();
        }
    }
}
