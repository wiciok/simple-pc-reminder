package logic.event;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 * Created by Witek on 2016-05-22.
 * podstawowa klasa kaÅ¼dego wydarzenia. to jej obiekty bÄ™dÄ… tworzone w trakcie dziaÅ‚ania programu
 *
 * umieÅ›ciÄ‡ tutaj info jakie funkcjonalnoÅ›ci sÄ… zapewnione - przyda siÄ™ przy generowaniu dokumentacji
 *
 */

/*
 * toDo - MatiM:
+dorobiÄ‡ pola:
     -data wydarzenia
     -nazwa
     -opis
     -czÄ™stotliwoÅ›Ä‡ przypomnieÅ„
     -czy aktywne
     -kategoria
     -priorytet

 +dorobiÄ‡ metody:
     -zwracanie wszystkich danych (toString)
     -zwracanie kaÅ¼dej danej, np. getName, getFreqency, getCategory, itd. waÅ¼ne Å¼eby byÅ‚o zwracanie kopii jeÅ›li dany obiekt jest zmienialny
     -konstruktory
     -cloneable (musi byÄ‡ bo obiekty bÄ™dÄ… tworzone na  zasadzie prototypu)

 +uzupeÅ‚niaÄ‡ komentarz do generowania dokumnetacji o funkcjonalnoÅ›ci, jakie zapewnia klasa
 * */

/*
 * 	Klasa Event:
 * 	Implementujê interfejs Cloneable na potrzeby wykorzystania wzorca prototyp.
 * 	Klasa zawiera do wszystkich zmiennych settery i gettery (oprócz eventDataNow która pobiera aktualny czas za ka¿dym razem).
 * 	Postanowi³em jednak rozdzieliæ datê wydarzenia na oddzielnie datê i czas.
 * 	Czêsto chcemy przenieœæ wydarzenie np o tydzieñ lub tylko przesun¹æ godzinê myœlê ¿e tak bêdziewygodniej
 * 	Zw³aszcza jak pó¿niej bêdziemy u¿ywaæ tego graficznego kalendarza a tam chyba datê i godzinê wybiera siê oddzielnie.
 * 	Zaimplementowa³em kontruktory: domyœlny, sparametryzowany i kopiuj¹cy (mo¿e siê przyda).
 * 	Metoda toString() zwraca wszystkie dane tak by mo¿na by³o ³atwo je wyœwietliæ.
 * 	Metoda print() wyœwietla wszystkie dane w podobny sposób do toString() jednak jest voidem.
 * 	Metoda clone() s³u¿y do klonowania przesy³anych obiektów.
 * 	Nie dodawa³em zczytywania z klawiatury. Myœlê ¿e to nie jest potrzebne w klasie Event.
 * 	Postanowi³em domyœlnie ustawiaæ obacn¹ datê i czas w zmiennych zamiast zostawiaæ pustych.
 * 
 * 	LocalDate.parse("2015-12-23")/LocalTime.parse("17:15") - przyk³adowe nadanie daty do zmiennych ze stringa (póŸniej raczej to nie bêdzie ju¿ wykorzystywane)
 * 	Event prototype = new Event();
 * 	Event wydarzenia = (Event)prototype.clone() - Klonowanie obiektów przyk³ad
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
				"\nData rozpoczêcia wydarzenia: "+eventDateStart+
				"\nCzas rozpoczêcia wydarzenia: "+eventTimeStart+
				"\nData zakoñczenia wydarzenia: "+eventDateEnd+
				"\nCzas zakoñczenia wydarzenia: "+eventTimeEnd+
				"\nNazwa wydarzenia: "+name+
				"\nOpis wydarzenia: "+describe+
				"\nCzêstotliwoœæ przypomnieñ: "+alertFrequency+
				"\nCzy aktywne: "+isActive+
				"\nKategoria wydarzenia: "+cathegory+
				"\nPriorytet: "+priority;
	}
	
	public void print()
	{
		System.out.println("Data utworzenia wydarzenia: "+eventDateNow+
							"\nData rozpoczêcia wydarzenia: "+eventDateStart+
							"\nCzas rozpoczêcia wydarzenia: "+eventTimeStart+
							"\nData zakoñczenia wydarzenia: "+eventDateEnd+
							"\nCzas zakoñczenia wydarzenia: "+eventTimeEnd+
							"\nNazwa wydarzenia: "+name+
							"\nOpis wydarzenia: "+describe+
							"\nCzêstotliwoœæ przypomnieñ: "+alertFrequency+
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
