package logic.event;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 * Created by Witek on 2016-05-22.
 * podstawowa klasa każdego wydarzenia. to jej obiekty będą tworzone w trakcie działania programu
 *
 * umieścić tutaj info jakie funkcjonalności są zapewnione - przyda się przy generowaniu dokumentacji
 *
 */

/*
 * toDo - MatiM:
+dorobić pola:
     -data wydarzenia
     -nazwa
     -opis
     -częstotliwość przypomnień
     -czy aktywne
     -kategoria
     -priorytet

 +dorobić metody:
     -zwracanie wszystkich danych (toString)
     -zwracanie każdej danej, np. getName, getFreqency, getCategory, itd. ważne żeby było zwracanie kopii jeśli dany obiekt jest zmienialny
     -konstruktory
     -cloneable (musi być bo obiekty będą tworzone na  zasadzie prototypu)

 +uzupełniać komentarz do generowania dokumnetacji o funkcjonalności, jakie zapewnia klasa
 * */

/*
 * 	Klasa Event:
 * 	Implementuj� interfejs Cloneable na potrzeby wykorzystania wzorca prototyp.
 * 	Klasa zawiera do wszystkich zmiennych settery i gettery (opr�cz eventDataNow kt�ra pobiera aktualny czas za ka�dym razem).
 * 	Postanowi�em jednak rozdzieli� dat� wydarzenia na oddzielnie dat� i czas.
 * 	Cz�sto chcemy przenie�� wydarzenie np o tydzie� lub tylko przesun�� godzin� my�l� �e tak b�dziewygodniej
 * 	Zw�aszcza jak p�niej b�dziemy u�ywa� tego graficznego kalendarza a tam chyba dat� i godzin� wybiera si� oddzielnie.
 * 	Zaimplementowa�em kontruktory: domy�lny, sparametryzowany i kopiuj�cy (mo�e si� przyda).
 * 	Metoda toString() zwraca wszystkie dane tak by mo�na by�o �atwo je wy�wietli�.
 * 	Metoda print() wy�wietla wszystkie dane w podobny spos�b do toString() jednak jest voidem.
 * 	Metoda clone() s�u�y do klonowania przesy�anych obiekt�w.
 * 	Nie dodawa�em zczytywania z klawiatury. My�l� �e to nie jest potrzebne w klasie Event.
 * 	Postanowi�em domy�lnie ustawia� obacn� dat� i czas w zmiennych zamiast zostawia� pustych.
 * 
 * 	LocalDate.parse("2015-12-23")/LocalTime.parse("17:15") - przyk�adowe nadanie daty do zmiennych ze stringa (p�niej raczej to nie b�dzie ju� wykorzystywane)
 * 	Event prototype = new Event();
 * 	Event wydarzenia = (Event)prototype.clone() - Klonowanie obiekt�w przyk�ad
 * 
 * 	Czekam na sugestie.
 * 	Pozdrawiam Mateusz Maciejak
 * 
 * 
 */
public class Event implements Serializable, Cloneable
{
	private LocalDateTime eventDateNow = LocalDateTime.now();	// data utworzenia wydarzenia
	private LocalDate eventDateStart = LocalDate.now();
	private LocalTime eventTimeStart = LocalTime.now();
	private LocalDate eventDateEnd = LocalDate.now();
	private LocalTime eventTimeEnd = LocalTime.now();
	private String name = new String("");
	private String describe = new String("");
	private Integer alertFrequency = new Integer(1);
	private boolean isActive = false;
	private String cathegory = new String("");
	private Integer priority = new Integer(1);
	
	public Event()
	{		
		this.eventDateNow = LocalDateTime.now();
		this.eventDateStart = LocalDate.now();
		this.eventTimeStart = LocalTime.now();
		this.eventDateEnd = LocalDate.now();
		this.eventTimeEnd = LocalTime.now();
		this.name = new String("");
		this.describe = new String("");
		this.alertFrequency = new Integer(1);
		this.isActive = false;
		this.cathegory = new String("");
		this.priority = new Integer(1);
	}
	
	public Event(LocalDate eventDateStart, LocalTime eventTimeStart, LocalDate eventDateEnd, LocalTime eventTimeEnd, String name, String describe, Integer alertFrequency, boolean isActive, String cathegory, Integer priority)
	{		
		this.eventDateNow = LocalDateTime.now();
		this.eventDateStart = eventDateStart;
		this.eventTimeStart = eventTimeStart;
		this.eventDateEnd = eventDateEnd;
		this.eventTimeEnd = eventTimeEnd;
		this.name = new String(name);
		this.describe = new String(describe);
		this.alertFrequency = new Integer(alertFrequency);
		this.isActive = isActive;
		this.cathegory = new String(cathegory);
		this.priority = new Integer(priority);
	}
	
	public Event(Event copy)
	{
		this.eventDateNow = LocalDateTime.now();
		this.eventDateStart = copy.eventDateStart;
		this.eventTimeStart = copy.eventTimeStart;
		this.eventDateEnd = copy.eventDateEnd;
		this.eventTimeEnd = copy.eventTimeEnd;
		this.name = new String(copy.name);
		this.describe = new String(copy.describe);
		this.alertFrequency = new Integer(copy.alertFrequency);
		this.isActive = copy.isActive;
		this.cathegory = new String(copy.cathegory);
		this.priority = new Integer(copy.priority);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDescribe()
	{
		return this.describe;
	}
	
	public String getCathegory()
	{
		return this.cathegory;
	}
	
	public Integer getAlertFrequency()
	{
		int copy = alertFrequency;
		return copy;
	}
	
	public boolean getIsActive()
	{
		boolean copy = isActive;
		return copy;
		
	}
	
	public Integer getPriority()
	{
		int copy = priority;
		return copy;
	}
	
	public LocalDateTime getEventDateNow()
	{
		return this.eventDateNow;
	}
	
	public LocalDate getEventDateStart()
	{
		return this.eventDateStart;
	}
	
	public LocalTime getEventTimeStart()
	{
		return this.eventTimeStart;
	}
	
	public LocalDate getEventDateEnd()
	{
		return this.eventDateEnd;
	}
	
	public LocalTime getEventTimeEnd()
	{
		return this.eventTimeEnd;
	}
	
	public void setName(String name)
	{
		this.name = new String(name);
	}
	
	public void setDescribe(String describe)
	{
		this.describe = new String(describe);
	}
	
	public void setCathegory(String cathegory)
	{
		this.cathegory = new String(cathegory);
	}
	
	public void setAlertFrequency(Integer alertFrequency)
	{
		this.alertFrequency = new Integer(alertFrequency);
	}
	
	public void setIsActive(boolean isActive)
	{
		this.isActive = isActive;
	}
	
	public void setPriority(Integer priority)
	{
		this.priority = new Integer(priority);
	}
	
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
	
	public String toString()
	{		
		return "Data utworzenia wydarzenia: "+eventDateNow+
				"\nData rozpocz�cia wydarzenia: "+eventDateStart+
				"\nCzas rozpocz�cia wydarzenia: "+eventTimeStart+
				"\nData zako�czenia wydarzenia: "+eventDateEnd+
				"\nCzas zako�czenia wydarzenia: "+eventTimeEnd+
				"\nNazwa wydarzenia: "+name+
				"\nOpis wydarzenia: "+describe+
				"\nCz�stotliwo�� przypomnie�: "+alertFrequency+
				"\nCzy aktywne: "+isActive+
				"\nKategoria wydarzenia: "+cathegory+
				"\nPriorytet: "+priority;
	}
	
	public void print()
	{
		System.out.println("Data utworzenia wydarzenia: "+eventDateNow+
							"\nData rozpocz�cia wydarzenia: "+eventDateStart+
							"\nCzas rozpocz�cia wydarzenia: "+eventTimeStart+
							"\nData zako�czenia wydarzenia: "+eventDateEnd+
							"\nCzas zako�czenia wydarzenia: "+eventTimeEnd+
							"\nNazwa wydarzenia: "+name+
							"\nOpis wydarzenia: "+describe+
							"\nCz�stotliwo�� przypomnie�: "+alertFrequency+
							"\nCzy aktywne: "+isActive+
							"\nKategoria wydarzenia: "+cathegory+
							"\nPriorytet: "+priority);
	}
	
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
