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

public class Event implements Serializable
{
	private LocalDateTime eventDateNow = LocalDateTime.now();	// data utworzenia wydarzenia
	private LocalDateTime eventDateStart = null;	//data rozpocz�cia
	private LocalDateTime eventDateEnd = null;	//data zako�czenia
	private String name = "";					// nazwa
	private String describe = "";				// opis
	private Integer alertFrequency = 1;
	private boolean isActive = false;
	private String cathegory = "";
	private Integer priority = 0;
	
	public Event()
	{		
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
	
	public LocalDateTime getEventDateStart()
	{
		return this.eventDateStart;
	}
	
	public LocalDateTime getEventDateEnd()
	{
		return this.eventDateEnd;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDescribe(String describe)
	{
		this.describe = describe;
	}
	
	public void setCathegory(String cathegory)
	{
		this.cathegory = cathegory;
	}
	
	public void setAlertFrequency(Integer alertFrequency)
	{
		this.alertFrequency = alertFrequency;
	}
	
	public void setIsActive(boolean isActive)
	{
		this.isActive = isActive;
	}
	
	public Object clone()
	{
		try
		{
			Event copy = (Event)super.clone(); 
			return copy;
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
