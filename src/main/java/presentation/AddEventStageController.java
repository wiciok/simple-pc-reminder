package presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Witek on 2016-06-15.
 *
 * ToDo: cała obsluga dodawania do bazy
 *
 * ToDo: button od dodawania: dodawanie tymczasowego Eventu (ktory bedzie mial parametry pobrane z kontrolek do bazy,
 * potem update schedulera, nastepnie zamkniecie stage'a
 *
 */
public class AddEventStageController implements Initializable
{
    private AddEventStage addEventStage;
    @FXML
    private Button cancelButton;

    public void setMainApp(AddEventStage AddEventStage)
    {
        this.addEventStage = AddEventStage;
    }

    public void initialize(URL url, ResourceBundle rb)
    {
        String cancelButtonText = new String("Cancel");
        cancelButton.setText(cancelButtonText);
        cancelButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                addEventStage.addEventStage.close();
            }
        });
    }



}
