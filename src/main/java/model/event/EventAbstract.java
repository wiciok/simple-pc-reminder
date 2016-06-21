package model.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Witek on 2016-06-20.
 *
 * Klasa abstrakcyjna będąca nadrzędną dla pozostałych klas Event.
 * Zawiera wspólne dla nich metody.
 */

abstract class EventAbstract
{
    public LocalDateTime getEventFullDateStart() { return LocalDateTime.of(getEventDateStart(), getEventTimeStart());}
    public LocalDateTime getEventFullDateEnd() { return LocalDateTime.of(getEventDateEnd(), getEventTimeEnd());}

    public abstract LocalDateTime getEventDateNow();
    public abstract LocalDate getEventDateStart();
    public abstract LocalTime getEventTimeStart();
    public abstract LocalDate getEventDateEnd();
    public abstract LocalTime getEventTimeEnd();
    public abstract String getTitle();
    public abstract String getDescription();
    public abstract String getCategory();
    public abstract Integer getAlertFrequency();
    public abstract Boolean getIsActive();
    public abstract Integer getPriority();

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
