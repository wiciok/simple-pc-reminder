package presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 * Created by Witek on 2016-06-15.
 */
public class AddEventStage
{
    presentation.Main mainApp;
    Stage addEventStage;
    private AnchorPane root; /*zmiana na AnchorPane*/


    AddEventStage(presentation.Main mainApp)
    {
        this.mainApp=mainApp;

        /*GridPane r2=new GridPane();
        Scene scene2 = new Scene(r2, 400, 400);
        addEventStage =new Stage();
        addEventStage.setScene(scene2);
        addEventStage.show();*/

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
