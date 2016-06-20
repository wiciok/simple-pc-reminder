package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import controller.AddEventStageController;

/**
 * Created by Witek on 2016-06-15.
 */
public class AddEventStage
{
    public Main mainApp;
    public Stage addEventStage;
    private AnchorPane root; /*zmiana na AnchorPane*/


    public AddEventStage(Main mainApp)
    {
        this.mainApp=mainApp;

        //---------------------------------
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
            e.printStackTrace();
        }
    }
}
