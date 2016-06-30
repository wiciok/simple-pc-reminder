/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import model.event.Event;
import model.event.EventSerializable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author mati
 */
public class DatabaseTest 
{
    
    public DatabaseTest() 
    {
    }
    

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
            System.out.printf("wszystko w porz¹dku\n");//ten wyj¹tek jest oczekiwany
        }
    }
  
}
