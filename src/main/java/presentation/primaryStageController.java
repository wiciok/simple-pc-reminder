package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import presentation.Main.*;

/**
 *
 * @author Witek
 */
public class primaryStageController implements Initializable
{
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void exampleHandleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
    }

   /* @FXML
    private void closeButtonAction(ActionEvent event)
    {
        primaryStage
    }*/




}