package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.event.Event;
import model.Scheduler;
import javafx.fxml.FXML;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import model.Database;
import view.AddEventStage;

/**
 * Created by Witek on 2016-06-15.
 * ToDo: sensowne wartosci dla prototypu
 *
 * ToDo: dorobic rzucanie wyjatku dla wprowadzonych zlych wartosci i okno alertu z infromacja dla usera
 *
 * ToDo: dekompozycja tych stringów
 */
public class AddEventStageController implements Initializable
{
    private AddEventStage addEventStage;
    @FXML private Button cancelButton;
    @FXML private Button createEventButton;
    @FXML private DatePicker pickStartDate;
    @FXML private DatePicker pickEndDate;
    @FXML private TextArea eventDescriptionField;
    @FXML private TextField eventCategory;
    @FXML private TextField eventNameField;
    @FXML private TextField eventStartTime;
    @FXML private TextField eventEndTime;
    @FXML private ComboBox<Integer> eventPriority;
    private ObservableList<Integer> options = FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10);
    @FXML private ComboBox<Integer> alertFrequency;ObservableList<Integer> alertOptions = FXCollections.observableArrayList(1,2,3,4,5);
    @FXML private ComboBox<String> eventIsActive;
    private ObservableList<String> activeOptions = FXCollections.observableArrayList("True", "False");
    @FXML private Label l1;
    @FXML private Label l2;
    @FXML private Label l3;
    @FXML private Label l4;

    public void setMainApp(AddEventStage AddEventStage)
    {
        this.addEventStage = AddEventStage;
    }

    public void initialize(URL url, ResourceBundle rb)
    {
    	/*konfiguracja Cancel Button*/
        String cancelButtonText = new String("Cancel");
        cancelButton.setText(cancelButtonText);
        cancelButton.setOnAction(event -> addEventStage.addEventStage.close());
        
        /*konfiguracja ComboBox (te rozwijane wybory)*/
        eventPriority.setItems(options);
        eventPriority.getSelectionModel().selectFirst();
        alertFrequency.setItems(alertOptions);
        alertFrequency.getSelectionModel().selectFirst();
        eventIsActive.setItems(activeOptions);
        eventIsActive.getSelectionModel().selectFirst();
        
        l1.setText("Choose Event Priority");
        l2.setText("Choose Alert Frequency");
        l3.setText("Make Event Active?");
        l4.setText("Format HH:MM:SS or HH:MM");
        
        pickStartDate.setEditable(false);
        pickStartDate.setPromptText("Choose Start Date");
        pickEndDate.setEditable(false);
        pickEndDate.setPromptText("Choose End Date");

        eventStartTime.setPromptText("Input Start Time");
        eventEndTime.setPromptText("Input End Time");
        
        eventDescriptionField.setWrapText(true);
        eventDescriptionField.setPromptText("Input Event Description");
        eventNameField.setPromptText("Input Event Name");
        eventCategory.setPromptText("Input Event Category");
        
        /*Konfiguracja Create Event button*/
        String createEventText = new String("Create Event");
        createEventButton.setText(createEventText);
        createEventButton.setOnAction(new EventHandler<ActionEvent>()
        {
        	public void handle(ActionEvent event)
            {
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
        		if(pickStartDate.getValue() != null && !pickStartDate.getValue().isBefore(LocalDate.now()))
        			newEvent.setEventDateStart(pickStartDate.getValue());
        		
        		/*walidacja tego czasu - najpierw jest sprawdzane czy w ogole cos zostalo wprowadzone
        		 * i potem dopiero czy to wprowadzone ma jakis sens - formaty HH:MM:SS lub HH:MM
        		 * i potem konwertowane do czasu*/

        		if(eventStartTime.getText() != null && !(eventStartTime.getText().trim().isEmpty()))
        		{
        			if(eventStartTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)") || eventStartTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d)"))
        				newEvent.setEventTimeStart(LocalTime.parse(eventStartTime.getText()));
        		}
        		
        		/*data zakonczenia - sprawdzane czy cos jest wybrane i czy data zakonczenia jest pozniejsza od obecnej daty i daty rozpoczecia
        		 * (bo bez sensu dawac event w przeszlosci)*/

        		if(pickEndDate.getValue() != null && 
        				!pickEndDate.getValue().isBefore(newEvent.getEventDateStart()) && 
        				!pickEndDate.getValue().isBefore(LocalDate.now()))
        			newEvent.setEventDateEnd(pickEndDate.getValue());
        		
        		/*znow walidacja czasu tym razem zakonczenia*/
        		if(eventEndTime.getText() != null && !(eventEndTime.getText().trim().isEmpty()))
        		{
        			if(eventEndTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)") || eventEndTime.getText().matches("([0-1]?\\d|2[0-3]):([0-5]?\\d)"))
        				newEvent.setEventTimeEnd(LocalTime.parse(eventEndTime.getText()));
        		}
        		
        		/* tu zawsze wybrana jest wartosc domyslna w razie jakby nic nie wybrał uzytkownik - widac w GUI*/
        		newEvent.setPriority(eventPriority.getSelectionModel().getSelectedItem());
        		newEvent.setAlertFrequency(alertFrequency.getSelectionModel().getSelectedItem());
        		newEvent.setIsActive(Boolean.parseBoolean(eventIsActive.getSelectionModel().getSelectedItem()));
        		
        		/*dodanie eventu do bazy, refresh glownego okna i zamkniecie stage'a*/
                Database.getInstance().add(newEvent);
                addEventStage.mainApp.controller.scheduler.update();
                addEventStage.addEventStage.close();
            }
        });
    }


}
