package presentation;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Witek
 * Klasa kontrolera gównej sceny (okna)
 */
public class primaryStageController implements Initializable
{
    private presentation.Main mainApp;
    public primaryStageController(){};


    //robię to tutaj, żeby była dekompozycja zależności i dało się to łatwo zmienić
    String buttonCloseText = new String("Close");
    String buttonAddText = new String("Add Event");


    //jeśli w SceneBuilderze nadaliśmy kontrolce takie samo ID jak nazwa obiektu
    //to zostaną one automatycznie połączone - do zmiennej obiektowej zostanie przypisany obiekt
    //potrzebna jest do tego oczywiscie adnotacja @FXML
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonAdd;



    public void setMainApp(Main mainApp)
    {
        this.mainApp = mainApp;
    }


    public void initialize(URL url, ResourceBundle rb)
    {
        buttonClose.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                mainApp.primaryStage.close();
            }
        });
        
        buttonAdd.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                GridPane r2=new GridPane();
                Scene scene2 = new Scene(r2, 400, 400);
                mainApp.addEventStage =new Stage();
                mainApp.addEventStage.setScene(scene2);
                mainApp.addEventStage.show();
            }
        });

        buttonClose.setText(buttonCloseText);
        buttonAdd.setText(buttonAddText);
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


}