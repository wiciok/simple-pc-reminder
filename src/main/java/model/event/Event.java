package model.event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

import javafx.beans.property.*;

/**
 * @author Witold Karaś on 2016-06-20.
 *
 * Klasa wydarzenia zawierająca elementy Property, konieczne do dynamicznego odświeżania się widoku.
 * Implementuje interfejs Cloneable na potrzeby wykorzystania wzorca prototyp.
 */

//Todo: dekompozycja

public class Event extends EventAbstract implements Cloneable
{
	ObjectProperty<LocalDateTime> eventDateNow;
	ObjectProperty<LocalDate> eventDateStart;
	ObjectProperty<LocalTime> eventTimeStart;
	ObjectProperty<LocalDate> eventDateEnd;
	ObjectProperty<LocalTime> eventTimeEnd;
	StringProperty title;
	StringProperty description;
	StringProperty category;
	IntegerProperty alertFrequency;
	BooleanProperty isActive;
	IntegerProperty priority;
	
	/*Default*/
	public static String defaultTitle = "New Event";
	public static String defaultCategory = "Empty";
	public static String defaultIsActive = "True";
	public static Integer defaultPriority = 0;
	public static Integer defaultAlertFrequency = 1;

	public Event()
	{		
		this.eventDateNow = new SimpleObjectProperty<>(LocalDateTime.now());
		this.eventDateStart = new SimpleObjectProperty<>(LocalDate.now());
		this.eventTimeStart = new SimpleObjectProperty<>(LocalTime.now());
		this.eventDateEnd = new SimpleObjectProperty<>(LocalDate.now());
		this.eventTimeEnd = new SimpleObjectProperty<>(LocalTime.now());
		this.title = new SimpleStringProperty(defaultTitle);
		this.description = new SimpleStringProperty("empty");
		this.category = new SimpleStringProperty(defaultCategory);
		this.alertFrequency = new SimpleIntegerProperty(defaultAlertFrequency);
		this.isActive = new SimpleBooleanProperty(Boolean.parseBoolean(defaultIsActive));
		this.priority = new SimpleIntegerProperty(defaultPriority);
	}
	
	public Event(LocalDate eventDateStart, LocalTime eventTimeStart, LocalDate eventDateEnd, LocalTime eventTimeEnd,
				 String title, String description, String category, int alertFrequency, boolean isActive, int priority)
	{
		this.eventDateNow = new SimpleObjectProperty<>(LocalDateTime.now());
		this.eventDateStart = new SimpleObjectProperty<>(eventDateStart);
		this.eventTimeStart = new SimpleObjectProperty<>(eventTimeStart);
		this.eventDateEnd = new SimpleObjectProperty<>(eventDateEnd);
		this.eventTimeEnd = new SimpleObjectProperty<>(eventTimeEnd);
		this.title = new SimpleStringProperty(title);
		this.description = new SimpleStringProperty(description);
		this.category = new SimpleStringProperty(category);
		this.alertFrequency = new SimpleIntegerProperty(alertFrequency);
		this.isActive = new SimpleBooleanProperty(isActive);
		this.priority = new SimpleIntegerProperty(priority);
	}
	
	public Event(Event copy)
	{
		this.eventDateNow = new SimpleObjectProperty<>(LocalDateTime.now());
		this.eventDateStart = new SimpleObjectProperty<>(copy.eventDateStart.get());
		this.eventTimeStart = new SimpleObjectProperty<>(copy.eventTimeStart.get());
		this.eventDateEnd = new SimpleObjectProperty<>(copy.eventDateEnd.get());
		this.eventTimeEnd = new SimpleObjectProperty<>(copy.eventTimeEnd.get());
		this.title = new SimpleStringProperty(copy.title.get());
		this.description = new SimpleStringProperty(copy.description.get());
		this.category = new SimpleStringProperty(copy.category.get());
		this.alertFrequency = new SimpleIntegerProperty(copy.alertFrequency.get());
		this.isActive = new SimpleBooleanProperty(copy.isActive.get());
		this.priority = new SimpleIntegerProperty(copy.priority.get());
	}

	public Event(EventSerializable copy)
	{
		this.eventDateNow = new SimpleObjectProperty<>(LocalDateTime.now());
		this.eventDateStart = new SimpleObjectProperty<LocalDate>(copy.getEventDateStart());
		this.eventTimeStart = new SimpleObjectProperty<LocalTime>(copy.getEventTimeStart());
		this.eventDateEnd = new SimpleObjectProperty<LocalDate>(copy.getEventDateEnd());
		this.eventTimeEnd = new SimpleObjectProperty<LocalTime>(copy.getEventTimeEnd());
		this.title = new SimpleStringProperty(copy.getTitle());
		this.description = new SimpleStringProperty(copy.getDescription());
		this.category = new SimpleStringProperty(copy.getCategory());
		this.alertFrequency = new SimpleIntegerProperty(copy.getAlertFrequency());
		this.isActive = new SimpleBooleanProperty(copy.getIsActive());
		this.priority = new SimpleIntegerProperty(copy.getPriority());
	}


	public LocalDateTime getEventDateNow() {return this.eventDateNow.get();}
	public LocalDate getEventDateStart() {return this.eventDateStart.get();}
	public LocalTime getEventTimeStart() {return this.eventTimeStart.get();}
	public LocalDate getEventDateEnd() {return this.eventDateEnd.get();}
	public LocalTime getEventTimeEnd() {return this.eventTimeEnd.get();}
	public String getTitle() {return this.title.get();}
	public String getDescription() {return this.description.get();}
	public String getCategory() {return this.category.get();}
	public Integer getAlertFrequency() {return this.alertFrequency.get();}
	public Boolean getIsActive() {return this.isActive.get();}
	public Integer getPriority() {return this.priority.get();}


	public ObjectProperty<LocalDateTime> getEventDateNowProperty() {return this.eventDateNow;}
	public ObjectProperty<LocalDate> getEventDateStartProperty() {return this.eventDateStart;}
	public ObjectProperty<LocalTime> getEventTimeStartProperty() {return this.eventTimeStart;}
	public ObjectProperty<LocalDate> getEventDateEndProperty() {return this.eventDateEnd;}
	public ObjectProperty<LocalTime> getEventTimeEndProperty() {return this.eventTimeEnd;}
	public StringProperty getTitleProperty() {return this.title;}
	public StringProperty getDescriptionProperty() {return this.description;}
	public StringProperty getCategoryProperty() {return this.category;}
	public IntegerProperty getAlertFrequencyProperty() {return this.alertFrequency;}
	public BooleanProperty getIsActiveProperty() {return this.isActive;}
	public IntegerProperty getPriorityProperty() {return this.priority;}


	public void setEventDateStart(LocalDate eventDateStart) {this.eventDateStart.set(eventDateStart);}
	public void setEventTimeStart(LocalTime eventTimeStart) {this.eventTimeStart.set(eventTimeStart);}
	public void setEventDateEnd(LocalDate eventDateEnd) {this.eventDateEnd.set(eventDateEnd);}
	public void setEventTimeEnd(LocalTime eventTimeEnd) {this.eventTimeEnd.set(eventTimeEnd);}
	public void setTitle(String title) {this.title.set(title);}
	public void setDescription(String description) {this.description.set(description);}
	public void setCategory(String category) {this.category.set(category);}
	public void setAlertFrequency(int alertFrequency) {this.alertFrequency.set(alertFrequency);}
	public void setIsActive(boolean isActive) {this.isActive.set(isActive);}
	public void setPriority(int priority) {this.priority.set(priority);}

}
