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
 * 	Mateusz Maciejak.
 */

//ToDo: moze uda sie uzyc czegos innego niz niepewne protected
public class EventSerializable implements Serializable, Cloneable
{
	private LocalDateTime eventDateNow;	// data utworzenia wydarzenia
	private LocalDate eventDateStart;
	private LocalTime eventTimeStart;
	private LocalDate eventDateEnd;
	private LocalTime eventTimeEnd;
	private String title;
	private String description;
	private String category;
	private int alertFrequency;
	private boolean isActive;
	private int priority;

	/*public EventSerializable()
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
	}

	public EventSerializable(LocalDate eventDateStart, LocalTime eventTimeStart, LocalDate eventDateEnd, LocalTime eventTimeEnd,
							 String name, String description, String category, int alertFrequency, boolean isActive, int priority)
	{
		this.eventDateNow = LocalDateTime.now();
		this.eventDateStart = eventDateStart;
		this.eventTimeStart = eventTimeStart;
		this.eventDateEnd = eventDateEnd;
		this.eventTimeEnd = eventTimeEnd;
		this.title = new String(name);
		this.description = new String(description);
		this.category = new String(category);
		this.alertFrequency = alertFrequency;
		this.isActive = isActive;
		this.priority = priority;
	}

	public EventSerializable(EventSerializable copy)
	{
		this.eventDateNow = LocalDateTime.now();
		this.eventDateStart = copy.eventDateStart;
		this.eventTimeStart = copy.eventTimeStart;
		this.eventDateEnd = copy.eventDateEnd;
		this.eventTimeEnd = copy.eventTimeEnd;
		this.title = new String(copy.title);
		this.description = new String(copy.description);
		this.category = new String(copy.category);
		this.alertFrequency = copy.alertFrequency;
		this.isActive = copy.isActive;
		this.priority = copy.priority;
	}*/

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


	public LocalDateTime getEventFullDateStart() { return LocalDateTime.of(getEventDateStart(), getEventTimeStart());}

	public LocalDateTime getEventDateNow()
	{
		return this.eventDateNow;
	}
	public LocalDate getEventDateStart() {return this.eventDateStart;}
	public LocalTime getEventTimeStart() {return this.eventTimeStart;}
	public LocalDate getEventDateEnd() {return this.eventDateEnd;}
	public LocalTime getEventTimeEnd() {return this.eventTimeEnd;}
	public String getTitle() {return this.title;}
	public String getDescription()
	{
		return this.description;
	}
	public String getCategory()
	{
		return this.category;
	}
	public Integer getAlertFrequency() {return new Integer(alertFrequency);}
	public Boolean getIsActive() {return new Boolean(isActive);}
	public Integer getPriority() {return new Integer(priority);}


	public String getEventDateStartString() {return this.eventDateStart.toString();}
	public String getEventTimeStartString() {return this.eventTimeStart.toString();}
	public String getEventDateEndString() {return this.eventDateEnd.toString();}
	public String getEventTimeEndString() {return this.eventTimeEnd.toString();}
	public String getAlertFrequencyString() {return new Integer(alertFrequency).toString();}
	public String getIsActiveString() {return new Boolean(isActive).toString();}
	public String getPriorityString() {return new Integer(priority).toString();}


	public void setEventDateStart(LocalDate eventDateStart)
	{
		this.eventDateStart = eventDateStart;
	}
	public void setEventTimeStart(LocalTime eventTimeStart)
	{
		this.eventTimeStart = eventTimeStart;
	}
	public void setEventDateEnd(LocalDate eventDateEnd)
	{
		this.eventDateEnd = eventDateEnd;
	}
	public void setEventTimeEnd(LocalTime eventTimeEnd)
	{
		this.eventTimeEnd = eventTimeEnd;
	}
	public void setTitle(String title) {this.title = new String(title);}
	public void setDescription(String description)
	{
		this.description = new String(description);
	}
	public void setCategory(String category)
	{
		this.category = new String(category);
	}
	public void setAlertFrequency(int alertFrequency) {this.alertFrequency = alertFrequency;}
	public void setIsActive(boolean isActive)
	{
		this.isActive = isActive;
	}
	public void setPriority(int priority) {this.priority = priority;}


	public String toString()
	{		
		return "Data utworzenia wydarzenia: "+eventDateNow+
				"\nData rozpoczęcia wydarzenia: "+eventDateStart+
				"\nCzas rozpoczęcia wydarzenia: "+eventTimeStart+
				"\nData zakończenia wydarzenia: "+eventDateEnd+
				"\nCzas zakończenia wydarzenia: "+eventTimeEnd+
				"\nNazwa wydarzenia: "+ title +
				"\nOpis wydarzenia: "+ description +
				"\nCzęstotliwość przypomnień: "+alertFrequency+
				"\nCzy aktywne: "+isActive+
				"\nKategoria wydarzenia: "+ category +
				"\nPriorytet: "+priority;
	}

	/**
	 *
	 *  Przykład:
	 *  Event prototype = new Event();
	 * 	Event wydarzenia = (Event)prototype.clone() -
	 * */
	public Object clone()
	{
		try {return super.clone();}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
