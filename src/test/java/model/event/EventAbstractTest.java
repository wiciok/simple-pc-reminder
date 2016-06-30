package model.event;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * @author Mateusz Najbor
 * klasa testująca działanie metody clone
 */
public class EventAbstractTest
{
    
    public EventAbstractTest() {}

    @Test
    public void testClone()
    {
        System.out.println("clone");
        Event esTest = new Event((LocalDate.of(2014, 1, 1)), (LocalTime.of(12,20,25,40)), (LocalDate.of(2014, 2, 1)), (LocalTime.of(22,20,25,40)), "tytul test", "opis test", "kategoria test", 2, true, 2);
        Event wydarzenia = (Event)esTest.clone();
        assertNotSame(esTest, wydarzenia);//sprawdznie czy obiekty nie są tym samym obiektem
        assertEquals(esTest.getDescription(), wydarzenia.getDescription());
    }
    
}
