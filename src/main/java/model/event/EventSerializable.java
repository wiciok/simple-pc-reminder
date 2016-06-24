package model.event;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *  Created by Witek on 2016-05-22.
 *  Klasa wykorzystywana do zapisu na dysk, z racji niemożności zapisu obiektów klasy Event
 *
 * 	LocalDate.parse("2015-12-23")/LocalTime.parse("17:15") - przykładowe nadanie daty do zmiennych ze stringa (później raczej to nie będzie już wykorzystywane)
 *
 *  Przykład klonowania:
 *  Event prototype = new Event();
 * 	Event wydarzenia = (Event)prototype.clone() -
 *
 *
 * 	Mateusz Maciejak.
 */

public class EventSerializable extends EventAbstract implements Serializable, Cloneable
{
	private LocalDateTime eventDateNow;	// data utworzenia wydarzenia
	private LocalDate eventDateStart;
	private LocalTime eventTimeStart;
	private LocalDate eventDateEnd;
	private LocalTime eventTimeEnd;
	private String title;
	private String description;
	private String category;
	private Integer alertFrequency;
	private Boolean isActive;
	private Integer priority;

	public EventSerializable(Event copy)
	{
		this.eventDateNow = LocalDateTime.now();
		this.eventDateStart = copy.getEventDateStart();
		this.eventTimeStart = copy.getEventTimeStart();
		this.eventDateEnd = copy.getEventDateEnd();
		this.eventTimeEnd = copy.getEventTimeEnd();
		this.title = copy.getTitle();
		this.description = copy.getDescription();
		this.category = copy.getCategory();
		this.alertFrequency = copy.getAlertFrequency();
		this.isActive = copy.getIsActive();
		this.priority = copy.getPriority();
	}

	public LocalDateTime getEventDateNow() {return this.eventDateNow;}
	public LocalDate getEventDateStart() {return this.eventDateStart;}
	public LocalTime getEventTimeStart() {return this.eventTimeStart;}
	public LocalDate getEventDateEnd() {return this.eventDateEnd;}
	public LocalTime getEventTimeEnd() {return this.eventTimeEnd;}
	public String getTitle() {return this.title;}
	public String getDescription() {return this.description;}
	public String getCategory() {return this.category;}
	public Integer getAlertFrequency() {return this.alertFrequency;}
	public Boolean getIsActive() {return this.isActive;}
	public Integer getPriority() {return this.priority;}

}
