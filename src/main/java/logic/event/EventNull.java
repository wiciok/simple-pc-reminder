package logic.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Witek on 2016-06-08.
 * klasa jest używana, gdy jest potrzeba wyświetlić obiekt klasy Event, a jednocześnie powinien on być pusty
 * dziedziczy strukturę klasy Event, a jednocześnie zwraca puste stringi
 * przy okazji jest również wykorzystywany polimorfizm
 */
public class EventNull extends Event
{
    /*public EventNull()
    {
        this.eventDateNow = LocalDateTime.now();
        this.eventDateStart = LocalDate.now();
        this.eventTimeStart = LocalTime.now();
        this.eventDateEnd = LocalDate.now();
        this.eventTimeEnd = LocalTime.now();
        this.title = new String("");
        this.description = new String("");
        this.category = new String("");
        this.alertFrequency = 1;
        this.isActive = false;
        this.priority = 1;
    }*/

    @Override
    public String getEventDateStartString() {return new String("");}
    public String getEventTimeStartString() {return new String("");}
    public String getEventDateEndString() {return new String("");}
    public String getEventTimeEndString() {return new String("");}
    public String getAlertFrequencyString() {return new String("");}
    public String getIsActiveString() {return new String("");}
    public String getPriorityString() {return new String("");}



}
