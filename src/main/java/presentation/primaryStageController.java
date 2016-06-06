package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Witek
 */
public class primaryStageController implements Initializable
{

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
    }

    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

}