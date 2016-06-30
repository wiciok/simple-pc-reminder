/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mati
 * klasa testuj¹ca dzia³anie metody clone
 */
public class EventAbstractTest
{
    
    public EventAbstractTest()
    {
    }
    

    @Test
    public void testClone()
    {
        System.out.println("clone");
        Event esTest = new Event((LocalDate.of(2014, 1, 1)), (LocalTime.of(12,20,25,40)), (LocalDate.of(2014, 2, 1)), (LocalTime.of(22,20,25,40)), "tytul test", "opis test", "kategoria test", 2, true, 2);
        Event wydarzenia = (Event)esTest.clone();
        assertNotSame(esTest, wydarzenia);//sprawdznie czy obiekty nie s¹ tym samym obiektem
        assertEquals(esTest.getDescription(), wydarzenia.getDescription());
    }
    
}
