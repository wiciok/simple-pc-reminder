package model.event;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Witek on 2016-06-08.
 * klasa jest używana, gdy jest potrzeba wyświetlić obiekt klasy Event, a jednocześnie powinien on być pusty
 * dziedziczy strukturę klasy Event, a jednocześnie zwraca puste stringi
 * przy okazji jest również wykorzystywany polimorfizm
 *
 *
 */
public class EventNull extends Event
{
    public EventNull()
    {
        this.eventDateNow = new SimpleObjectProperty<>(LocalDateTime.now());
        this.eventDateStart = new SimpleObjectProperty<>(LocalDate.now());
        this.eventTimeStart = new SimpleObjectProperty<>(LocalTime.now());
        this.eventDateEnd = new SimpleObjectProperty<>(LocalDate.now());
        this.eventTimeEnd = new SimpleObjectProperty<>(LocalTime.now());
        this.title = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
        this.category = new SimpleStringProperty("");
        this.alertFrequency = new SimpleIntegerProperty(0);
        this.isActive = new SimpleBooleanProperty(false);
        this.priority = new SimpleIntegerProperty(0);
    }

    public String getEventDateStartString() {return new String("");}
    public String getEventTimeStartString() {return new String("");}
    public String getEventDateEndString() {return new String("");}
    public String getEventTimeEndString() {return new String("");}
    public String getAlertFrequencyString() {return new String("");}
    public String getIsActiveString() {return new String("");}
    public String getPriorityString() {return new String("");}

}
