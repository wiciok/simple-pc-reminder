package logic.event;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 * Created by Witek on 2016-05-22.
 * podstawowa klasa każdego wydarzenia. to jej obiekty będą tworzone w trakcie działania programu
 *
 *
 * 	Klasa Event:
 * 	Implementuje interfejs Cloneable na potrzeby wykorzystania wzorca prototyp.
 * 	Klasa zawiera do wszystkich zmiennych settery i gettery (oprócz eventDataNow która pobiera aktualny czas za każdym razem).
 * 	Postanowiłem jednak rozdzielić datę wydarzenia na oddzielnie datę i czas.
 * 	Często chcemy przenieść wydarzenie np o tydzień lub tylko przesunąć godzinę myślę że tak będzie wygodniej
 * 	Zwłaszcza jak póniej będziemy używać tego graficznego kalendarza a tam chyba datę i godzinę wybiera się oddzielnie.
 * 	Zaimplementowałem kontruktory: domyślny, sparametryzowany i kopiujący (może się przyda).
 * 	Metoda toString() zwraca wszystkie dane tak by można było łatwo je wyświetlić.
 * 	Metoda print() wyświetla wszystkie dane w podobny sposób do toString() jednak jest voidem.
 * 	Metoda clone() służy do klonowania przesyłanych obiektów.
 * 	Nie dodawałem zczytywania z klawiatury. Myślę że to nie jest potrzebne w klasie Event.
 * 	Postanowiłem domyślnie ustawiać obacną datę i czas w zmiennych zamiast zostawiać pustych.
 *
 * 	LocalDate.parse("2015-12-23")/LocalTime.parse("17:15") - przykładowe nadanie daty do zmiennych ze stringa (później raczej to nie będzie już wykorzystywane)
 * 	Event prototype = new Event();
 * 	Event wydarzenia = (Event)prototype.clone() - Klonowanie obiektów przykład
 *
 * 	Czekam na sugestie.
 * 	Pozdrawiam Mateusz Maciejak
 *
 * 	---------------------------
 * 	zmiany są ogółem ok, ale spowodują problem przy próbie posortowania po dacie rozpoczęcia - cieżko bedzie posortowac
 * 	wydarzenia, które dzieją się tego samego dnia
 *
 * 	sugeruję:
 * 	ToDO: dorobić metody zwracające jednocześnie czas i datę (startu i zakończenia) na podstawie pól data i czas
 *
 *
 */

//ToDo: moze uda sie uzyc czegos innego niz niepewne protected
public class Event implements Serializable, Cloneable
{
	protected LocalDateTime eventDateNow;	// data utworzenia wydarzenia
	protected LocalDate eventDateStart;
	protected LocalTime eventTimeStart;
	protected LocalDate eventDateEnd;
	protected LocalTime eventTimeEnd;
	protected String title;
	protected String description;
	protected String category;
	protected int alertFrequency;
	protected boolean isActive;
	protected int priority;
	
	public Event()
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
	
	public Event(LocalDate eventDateStart, LocalTime eventTimeStart, LocalDate eventDateEnd, LocalTime eventTimeEnd,
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
	
	public Event(Event copy)
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
	public String getTitle()
	{
		return this.title;
	}
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
	public void setTitle(String title)
	{
		this.title = new String(title);
	}
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
