package model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    public static ObservableList<Event> taskDisplayList = FXCollections.observableArrayList();
    //ToDo: modyfikator dostępu
    public static int currentPage;

    public Scheduler(controller.MainStageController controller)
    {
        this.mainStageController=controller;
        currentPage=1;
    }

    public void update()
    {
        try
        {
            Database.getInstance().sort();
            System.out.println("posortowano!");
        }
        catch (IndexOutOfBoundsException e)
        {
            //ToDo: jesl bedzie jakis logger, to dac info ze sortowanie nieudane bo pusta baza
            System.out.println("sortowanie nieudane!");
        }

        taskDisplayList.clear();
        for (int i=(currentPage-1)*3, k=0; i<(currentPage)*3; i++, k++)
        //for (int i=0; i<3; i++)
        {
            //System.out.print("iter: ");
           // System.out.println(i);
            try
            {
                final int j = k;
                final ChangeListener<String> list = new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {
                        mainStageController.update.updateIndex(j, newValue);
                    }
                };

                taskDisplayList.add(Database.getInstance().get(i));
                Scheduler.taskDisplayList.get(k).getTitleProperty().addListener(list);
                String tmp=Database.getInstance().get(i).getTitle();
                taskDisplayList.get(k).getTitleProperty().set("__force change of value");
                taskDisplayList.get(k).getTitleProperty().set(tmp);

                Scheduler.taskDisplayList.get(k).getTitleProperty().removeListener(list);
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
            System.out.println("posortowano!");
        }
        catch (IndexOutOfBoundsException e)
        {
            //ToDo: jesl bedzie jakis logger, to dac info ze sortowanie nieudane bo pusta baza
            System.out.println("sortowanie nieudane!");
        }

        currentPage=0;

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

    public void getNext()
    {
        System.out.println("getNext");
        currentPage+=1;
        update();
    }

    public void getPrev()
    {
        System.out.println("getPrev");
        currentPage-=1;
        if (currentPage<1)
            currentPage=1;
        update();
    }



}
