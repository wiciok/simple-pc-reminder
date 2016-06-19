package logic.event;

import data.Database;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import logic.event.Event;
import javafx.collections.*;
import presentation.Main;

/**
 * Created by Witek on 2016-05-22.
 * tu najpewniej będzie jakiś scheduler, ale to wyjdzie w praniu
 */
public class Scheduler
{
    public static ObservableList<Event> taskDisplayList = FXCollections.observableArrayList();
    private static int currentPage=0;


    public static void update()
    {
        if(Database.getInstance().size()>1)
            Database.getInstance().sort();
        //taskDisplayList.clear();
        for (int i=0;i<3;i++)
        {
            try
            {
                //taskDisplayList.add(Database.getInstance().get(i));
                taskDisplayList.get(i).titleProperty().set(Database.getInstance().get(i).getTitle());
                //if(i==2)
                    //taskDisplayList.get(2).titleProperty().set(Database.getInstance().get(1).getTitle());
                    //taskDisplayList.get(2).titleProperty().set("gfdgdfgsfdgsdf");
                taskDisplayList.add(Database.getInstance().get(i));
            }
            catch(IndexOutOfBoundsException e)
            {
                taskDisplayList.add(new EventNull());
                //if(i==2)
                //    taskDisplayList.get(2).titleProperty().set("gfdgdfgsfdgsdf");
            }
        }
       // taskDisplayList.get(2).titleProperty().set(Database.getInstance().get(1).getTitle());
        //taskDisplayList.get(2).titleProperty().set("gfdgdfgsfdgsdf");

    }

    public static void init()
    {
        if(Database.getInstance().size()>1)
            Database.getInstance().sort();
        taskDisplayList.clear();
        for (int i=0;i<3;i++)
        {
            try
            {
                taskDisplayList.add(Database.getInstance().get(i));
            }
            catch(IndexOutOfBoundsException e)
            {
                taskDisplayList.add(new EventNull());
            }
        }
    }


    public static void getNext()
    {
        taskDisplayList.clear();
        for (int i=0;i<3;i++)
            taskDisplayList.add(Database.getInstance().get(i));
    }



}
