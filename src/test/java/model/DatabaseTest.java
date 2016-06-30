package model;

import model.event.Event;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Najbor
 * klasa testująca działanie klasy Database
 */
public class DatabaseTest 
{
    public DatabaseTest() {}

    /**
     * Test of readFromFile method, of class Database.
     */
    @Test
    public void testReadWriteFromFile() throws Exception
    {
        System.out.println("readFromFile");
        Database databaseStart; 
        databaseStart = Database.getInstance();
        
        databaseStart.readFromFile();
        Event instance = new Event((LocalDate.of(2014, 1, 1)), (LocalTime.of(12,20,25,40)), (LocalDate.of(2014, 2, 1)), (LocalTime.of(22,20,25,40)), "tytul test", "opis test", "kategoria test", 2, true, 2);  
        databaseStart.add(instance);
            
        databaseStart.writeToFile();
        databaseStart.readFromFile();
        
        Event instance2 = databaseStart.get(databaseStart.size() - 1);
        assertEquals(instance.getDescription(), instance2.getDescription());
        
        databaseStart.remove(databaseStart.size() - 1);
        databaseStart.writeToFile();
    }
    
    @Test
    public void testSort() throws Exception
    {
        System.out.println("sort");
        Database databaseSort; 
        databaseSort = Database.getInstance();
        try{databaseSort.sort();}
        catch(IndexOutOfBoundsException e)
        {
            System.out.printf("wszystko w porządku\n");//ten wyjątek jest oczekiwany
        }
    }
}
