package model;

import javafx.collections.ObservableList;
import javafx.collections.*;
import model.event.Event;
import model.event.EventNull;

/**
 * Created by Witek on 2016-05-22.
 * Klasa zajmująca się przygotowaniem danych do wyświetlenia
 *
 * ToDo: poprawic bug z update po wczytaniu z pliku
 *
 * ToDo: pomyslec nad zastosowaniem singletona
 */
public class Scheduler
{
    controller.MainStageController mainStageController;

    public Scheduler(controller.MainStageController controller)
    {
        this.mainStageController=controller;
    }


    public static ObservableList<Event> taskDisplayList = FXCollections.observableArrayList();
    private static int currentPage=0;


  /*  public static void update()
    {
        try
        {
            Database.getInstance().sort();
        }
        catch (IndexOutOfBoundsException e)
        {
            //ToDo: jesl bedzie jakis logger, to dac info ze sortowanie nieudane bo pusta baza
        }


        //ToDo: zrobic cos z rozrastajaca sie lista (gdzies w dobrym miejscu clear wywołać)
        //taskDisplayList.clear();
        for (int i=0;i<3;i++)
        {
            try
            {
                //taskDisplayList.get(i).getTitleProperty().set(Database.getInstance().get(i).getTitle());
                taskDisplayList.add(Database.getInstance().get(i));
            }
            catch(IndexOutOfBoundsException e)
            {
                taskDisplayList.add(new EventNull());
            }
        }
    }*/

    public void update()
    {
        try
        {
            Database.getInstance().sort();
        }
        catch (IndexOutOfBoundsException e)
        {
            //ToDo: jesl bedzie jakis logger, to dac info ze sortowanie nieudane bo pusta baza
        }

        taskDisplayList.clear();
        for (int i=0;i<3;i++)
        {
            try
            {
                final int j = i;
                taskDisplayList.add(Database.getInstance().get(i));
                Scheduler.taskDisplayList.get(i).getTitleProperty().addListener((observable, oldValue, newValue) -> mainStageController.update.updateIndex(j,newValue));
                String tmp=Database.getInstance().get(i).getTitle();
                taskDisplayList.get(i).getTitleProperty().set("__force change of value");
                taskDisplayList.get(i).getTitleProperty().set(tmp);

                //toDo: dorobic usuwanie listenera (najpewniej tzeba bedzie zastapic lambde normalna klasa)
                // Scheduler.taskDisplayList.get(i).getTitleProperty().removeListener();
            }
            catch(IndexOutOfBoundsException e)
            {
                taskDisplayList.add(new EventNull());
            }
        }


    }

    public static void init()
    {
        try
        {
            Database.getInstance().sort();
        }
        catch (IndexOutOfBoundsException e)
        {
            //ToDo: jesl bedzie jakis logger, to dac info ze sortowanie nieudane bo pusta baza
        }

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

    /*public static void update1(String s)
    {
        System.out.print("controller.update: ");
        System.out.println(s);
    }*/


}
