/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mati
 * klasa testuj¹ca wybrane metody klasy Event
 */
public class EventTest
{
     Event instance = new Event((LocalDate.of(2014, 1, 1)), (LocalTime.of(12,20,25,40)), (LocalDate.of(2014, 2, 1)), (LocalTime.of(22,20,25,40)), "tytul", "opis", "kategoria", 2, true, 2);
    
    public EventTest() 
    {
        System.out.print("Public EventTest - testowanie dzia³ania\n");
    }

    @org.junit.Test
    public void testGetEventDateStart()
    {
        System.out.println("getEventDateStart");
        Event instanceDate = new Event();
        LocalDate expResult = null;
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
        instance.setEventTimeStart(LocalTime.of(10,20,30,00));
        expResult = (LocalTime.of(10,20,30,00));
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
