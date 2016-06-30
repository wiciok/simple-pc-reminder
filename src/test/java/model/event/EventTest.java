package model.event;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Najbor
 * klasa testująca wybrane metody klasy Event
 */
public class EventTest
{
    private Event instance = new Event((LocalDate.of(2014, 1, 1)), (LocalTime.of(12,20,25,40)), (LocalDate.of(2014, 2, 1)), (LocalTime.of(22,20,25,40)), "tytul", "opis", "kategoria", 2, true, 2);
    
    public EventTest() 
    {
        System.out.println("Public EventTest - testowanie działania");
    }

    @org.junit.Test
    public void testGetEventDateStart()
    {
        LocalDate expResult = null;

        System.out.println("getEventDateStart");
        Event instanceDate = new Event();
        instanceDate.setEventDateStart(expResult);
        LocalDate result = instanceDate.getEventDateStart();
        assertEquals(expResult, result);
     }

    /**
     * Test of getEventTimeStart method, of class Event.
     */
    
    @org.junit.Test
    public void testGetEventTimeStart()
    {
        System.out.println("getEventTimeStart");
        LocalTime expResult = (LocalTime.of(12,20,25,40));
        LocalTime result = instance.getEventTimeStart();
        assertEquals(expResult, result);
        instance.setEventTimeStart(LocalTime.of(10,20,30,0));
        expResult = (LocalTime.of(10,20,30,0));
        result = instance.getEventTimeStart();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Event.
     */
    @org.junit.Test
    public void testGetTitle() 
    {
        System.out.println("getTitle");
        String result = instance.getTitle();
        assertEquals("tytul", result);
        instance.setTitle("");
        result = instance.getTitle();
        assertEquals("", result);
    }

    /**
     * Test of getDescription method, of class Event.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        String result = instance.getDescription();
        assertEquals("opis", result);
        instance.setDescription("nowy opis");
        result = instance.getDescription();
        assertEquals("nowy opis", result);
    }
}
