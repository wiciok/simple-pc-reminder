package presentation;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.event.Scheduler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Witek
 * Klasa kontrolera gównej sceny (okna)
 */
public class primaryStageController implements Initializable
{
    private presentation.Main mainApp;
    //presentation.Main mainApp;
    public primaryStageController(){};
    AddEventStage addEventStage;


    //robię to tutaj, żeby była dekompozycja zależności i dało się to łatwo zmienić
    String buttonCloseText = new String("Close");
    String buttonAddText = new String("Add Event");
    String buttonNextEventsText = new String("Next");
    String buttonPrevEventsText = new String("Previous");


    //jeśli w SceneBuilderze nadaliśmy kontrolce takie samo ID jak nazwa obiektu
    //to zostaną one automatycznie połączone - do zmiennej obiektowej zostanie przypisany obiekt
    //potrzebna jest do tego oczywiscie adnotacja @FXML
    @FXML
    private TitledPane paneEvent1;
    @FXML
    private TitledPane paneEvent2;
    @FXML
    private TitledPane paneEvent3;
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonNextEvents;
    @FXML
    private Button buttonPrevEvents;
    @FXML
    private Label labelEvent1Category;
    @FXML
    private Label labelEvent2Category;
    @FXML
    private Label labelEvent3Category;





    public void initialize(URL url, ResourceBundle rb)
    {
        buttonClose.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                mainApp.primaryStage.close();
            }
        });
        
        buttonAdd.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                addEventStage = new AddEventStage(mainApp);
            }
        });

        buttonNextEvents.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                mainApp.primaryStage.close();
            }
        });



        buttonClose.setText(buttonCloseText);
        buttonAdd.setText(buttonAddText);
        buttonPrevEvents.setText(buttonNextEventsText);
        buttonNextEvents.setText(buttonPrevEventsText);

        paneEvent1.setText(Scheduler.taskDisplayList.get(0).getTitle());
        paneEvent2.setText(Scheduler.taskDisplayList.get(1).getTitle());
        paneEvent3.setText(Scheduler.taskDisplayList.get(2).getTitle());

        labelEvent1Category.setText(Scheduler.taskDisplayList.get(0).getCategory());
        labelEvent2Category.setText(Scheduler.taskDisplayList.get(1).getCategory());
        labelEvent3Category.setText(Scheduler.taskDisplayList.get(2).getCategory());
    }


    @FXML
    /**
     * funkcja testowa
     * ToDo: do kasacji w przyszłości
     */
    private void exampleHandleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
    }

    public void setMainApp(Main mainApp)
    {
        this.mainApp = mainApp;
    }


}