package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private AddEventStageController controller;

    public AddEventStage(MainStage mainApp)
    {
        AnchorPane root;

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

            controller = addEventLoader.getController();
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

        //-----------------------------konfiguracja kontrolek-------------------------------------------

        controller.cancelButton.setText(Resources.AddEventStageRes.strCancel);
        controller.l1.setText(Resources.AddEventStageRes.strL1);
        controller.l2.setText(Resources.AddEventStageRes.strL2);
        controller.l3.setText(Resources.AddEventStageRes.strL3);
        controller.l4.setText(Resources.AddEventStageRes.strL4);

        controller.pickStartDate.setEditable(false);
        controller.pickStartDate.setPromptText(Resources.AddEventStageRes.strPickStartDate);
        controller.pickEndDate.setEditable(false);
        controller.pickEndDate.setPromptText(Resources.AddEventStageRes.strPickEndDate);

        controller.eventStartTime.setPromptText(Resources.AddEventStageRes.strEventStartTime);
        controller.eventEndTime.setPromptText(Resources.AddEventStageRes.strEventEndTime);

        controller.eventDescriptionField.setWrapText(true);
        controller.eventDescriptionField.setPromptText(Resources.AddEventStageRes.strEventDescriptionField);
        controller.eventNameField.setPromptText(Resources.AddEventStageRes.strEventNameField);
        controller.eventCategory.setPromptText(Resources.AddEventStageRes.strEventCategory);

        controller.createEventButton.setText(Resources.AddEventStageRes.strCreateEventButton);


        /*konfiguracja ComboBox (te rozwijane wybory)*/
        ObservableList<Integer> options = FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10);
        ObservableList<String> activeOptions = FXCollections.observableArrayList(Resources.AddEventStageRes.strTrue, Resources.AddEventStageRes.strFalse);
        ObservableList<Integer> alertOptions = FXCollections.observableArrayList(1,2,3,4,5);

        controller.eventPriority.setItems(options);
        controller.eventPriority.getSelectionModel().selectFirst();
        controller.alertFrequency.setItems(alertOptions);
        controller.alertFrequency.getSelectionModel().selectFirst();
        controller.eventIsActive.setItems(activeOptions);
        controller.eventIsActive.getSelectionModel().selectFirst();

        //-----------------------------------------------------------------------------------------------------
    }
}
