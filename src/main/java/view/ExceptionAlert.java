package view;

import javafx.scene.control.Alert;

/**
 * @author Witold Karaś on 2016-06-30.
 *
 * Klasa odpowiająca za wywoływanie komunikatów z wyjątkami
 */
public class ExceptionAlert
{
    private Alert alert;
    public ExceptionAlert(Alert.AlertType type, String headerText, String contextText)
    {
        alert = new Alert(type);
        alert.setTitle(type.toString());
        alert.setHeaderText(headerText);
        alert.setContentText(contextText);

        alert.showAndWait();
    }

    public ExceptionAlert(Alert.AlertType type, String contextText)
    {
        alert = new Alert(type);
        alert.setTitle(type.toString());
        alert.setHeaderText(null);
        alert.setContentText(contextText);

        alert.showAndWait();
    }
}
