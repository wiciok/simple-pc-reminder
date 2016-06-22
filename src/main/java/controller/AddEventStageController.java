package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.event.Event;
import javafx.fxml.FXML;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import model.Database;
import view.AddEventStage;

/**
 * Klasa kontrolera okna od dodawaia nowego wydarzenia.
 */
public class AddEventStageController implements Initializable
{
    private AddEventStage addEventStage;
    public int howManyHours;

    /*inicjalizacja kontrolek na scenie - wiązanie z plikiem FXML
    * możliwe do wykonania jedynie w klasie kontrolera*/

    @FXML public Button cancelButton;
    @FXML public Button createEventButton;
    @FXML public DatePicker pickStartDate;
    @FXML public DatePicker pickEndDate;
    @FXML public TextArea eventDescriptionField;
    @FXML public TextField eventCategory;
    @FXML public TextField eventNameField;
    @FXML public TextField eventStartTime;
    @FXML public TextField eventEndTime;
    @FXML public ComboBox<Integer> eventPriority;
    @FXML public ComboBox<Integer> alertFrequency;
    @FXML public ComboBox<String> eventIsActive;
    @FXML public Label l1;
    @FXML public Label l2;
    @FXML public Label l3;
    @FXML public Label l4;

    public void setMainApp(AddEventStage AddEventStage)
    {
        this.addEventStage = AddEventStage;
    }

    public void initialize(URL url, ResourceBundle rb)
    {
        /*konfiguracja Cancel Button*/
        cancelButton.setOnAction(event -> addEventStage.addEventStage.close());

        createEventButton.setOnAction(event -> {
            /* tworzenie prototypu Eventu - w konstruktorze sa ustawiane domyslne wartosci
             * ktore obowiazuja gdy uzytkownik tu czegos nie wprowadzi*/

            Event prototype = new Event(); //ToDo: ten prototyp powinien miec jakies sensowne wartosci, a nie to co ma konstruktor domyslnie
            Event newEvent = (Event)prototype.clone();

            /*Pobieranie wpisanych przez uzytkownika wartosci*/
            /*nazwa, opis, kategoria - sprawdzane czy po prostu cos zostalo wpisane*/
            if(eventNameField.getText() != null && !(eventNameField.getText().trim().isEmpty()))
                newEvent.setTitle(eventNameField.getText());

            if(eventDescriptionField.getText() != null && !(eventNameField.getText().trim().isEmpty()))
                newEvent.setDescription(eventDescriptionField.getText());

            if(eventCategory.getText() != null && !(eventCategory.getText().trim().isEmpty()))
                newEvent.setCategory(eventCategory.getText());

            /*data rozpoczenia - sprawdzane czy cos jest wybrane i czy data rozpoczecia jest pozniejsza od obecnej daty
             * (bo bez sensu dawac event w przeszlosci)*/
            try
            {
                   if(pickStartDate.getValue() != null && !pickStartDate.getValue().isBefore(LocalDate.now()))
                    newEvent.setEventDateStart(pickStartDate.getValue());
                   else
                       throw new Exception();
            }
            catch(Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Event start date warning!");
                alert.setContentText("No date set or the date is inproper.\n\nCurrent date will be set.");
                alert.showAndWait();
            }

            /*walidacja tego czasu - najpierw jest sprawdzane czy w ogole cos zostalo wprowadzone
             * i potem dopiero czy to wprowadzone ma jakis sens - formaty HH:MM:SS lub HH:MM
             * i potem konwertowane do czasu*/
            try
            {
                if(eventStartTime.getText() != null && !(eventStartTime.getText().trim().isEmpty()))
                {
                    if(eventStartTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)") || eventStartTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d)"))
                        newEvent.setEventTimeStart(LocalTime.parse(eventStartTime.getText()));
                    else
                        throw new Exception();
                }
                else throw new Exception();
            }
            catch(Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Event start time warning!");
                alert.setContentText("No time set or wrong format (HH:MM / HH:MM:SS)\ne.g. 09:50, 17:30:22.\n\nCurrent time is set.");
                alert.showAndWait();
            }

            /*data zakonczenia - sprawdzane czy cos jest wybrane i czy data zakonczenia jest pozniejsza od obecnej daty i daty rozpoczecia
             * (bo bez sensu dawac event w przeszlosci)*/
            try
            {
                if(pickEndDate.getValue() != null &&
                        !pickEndDate.getValue().isBefore(newEvent.getEventDateStart()) &&
                        !pickEndDate.getValue().isBefore(LocalDate.now()))
                    newEvent.setEventDateEnd(pickEndDate.getValue());
                else
                    throw new Exception();
            }
            catch(Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Event end date warning!");
                alert.setContentText("No date set or the date is inproper.\n\nCurrent date will be set.");
                alert.showAndWait();
            }

            /*znow walidacja czasu tym razem zakonczenia*/
            try
            {
                if(eventEndTime.getText() != null && !(eventEndTime.getText().trim().isEmpty()))
                {
                    if(eventEndTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)") || eventEndTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d)"))
                        newEvent.setEventTimeEnd(LocalTime.parse(eventEndTime.getText()));
                    else throw new Exception();
                }
                else throw new Exception();
            }
            catch(Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Event end time warning!");
                alert.setContentText("No time set or wrong format (HH:MM / HH:MM:SS)\ne.g. 09:50, 17:30:22.\n\nCurrent time is set.");
                alert.showAndWait();
            }

            /* tu zawsze wybrana jest wartosc domyslna w razie jakby nic nie wybrał uzytkownik - widac w GUI*/
            newEvent.setPriority(eventPriority.getSelectionModel().getSelectedItem());
            newEvent.setAlertFrequency(alertFrequency.getSelectionModel().getSelectedItem());
            newEvent.setIsActive(Boolean.parseBoolean(eventIsActive.getSelectionModel().getSelectedItem()));

            /*dodanie eventu do bazy, refresh glownego okna i zamkniecie stage'a*/
            Database.getInstance().add(newEvent);
            addEventStage.mainApp.controller.scheduler.update();
            addEventStage.addEventStage.close();
        });
    }
}
