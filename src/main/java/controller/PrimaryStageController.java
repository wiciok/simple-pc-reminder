package controller;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Scheduler;
import view.AddEventStage;
import view.Main;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Witek
 * Klasa kontrolera gównej sceny (okna)
 */
public class PrimaryStageController implements Initializable
{
    private Main mainApp;
    //view.Main mainApp;
    public PrimaryStageController(){};
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
                //todo: wyswietlanie kolejnych eventow
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


        Scheduler.taskDisplayList.get(0).titleProperty().addListener((observable, oldValue, newValue) -> update1(newValue));
        Scheduler.taskDisplayList.get(1).titleProperty().addListener((observable, oldValue, newValue) -> update2(newValue));
        Scheduler.taskDisplayList.get(2).titleProperty().addListener((observable, oldValue, newValue) -> update3(newValue));
    }

    public void setMainApp(Main mainApp)
    {
        this.mainApp = mainApp;
    }

    public void update1(String s)
    {
        paneEvent1.setText(s);
        System.out.println("controller.update1");
    }
    public void update2(String s)
    {
        paneEvent2.setText(s);
        System.out.println("controller.update2");
    }
    public void update3(String s)
    {
        paneEvent3.setText(s);
        System.out.println("controller.update3");
    }

}