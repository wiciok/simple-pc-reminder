package model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.*;
import model.event.Event;
import model.event.EventNull;

/**
 * @author Witold Karaś on 2016-05-22.
 * Klasa zajmująca się przygotowaniem danych do wyświetlenia
 */
public class Scheduler
{
    controller.MainStageController mainStageController;
    public static ObservableList<Event> taskDisplayList = FXCollections.observableArrayList();
    public static int currentPage;

    public Scheduler(controller.MainStageController controller)
    {
        this.mainStageController=controller;
        currentPage=1;
    }

    public void update()
    {
        try {Database.getInstance().sort();}
        catch (IndexOutOfBoundsException e) {}

        taskDisplayList.clear();
        for (int i=(currentPage-1)*3, k=0; i<(currentPage)*3; i++, k++)
        {
            try
            {
                final int j = k;

                /*Zastosowanie wzorca projektowego Obserwator -
                - użycie Listenera do obserwacji zmian wśród aktualnie wyświetlanych elementów*/
                final ChangeListener<String> list = (observable, oldValue, newValue) -> mainStageController.update.updateIndex(j);

                taskDisplayList.add(Database.getInstance().get(i));
                Scheduler.taskDisplayList.get(k).getTitleProperty().addListener(list);
                String tmp=Database.getInstance().get(i).getTitle();

                //wymuszenie zmiany wartości (konieczne aby listener "załapał")
                taskDisplayList.get(k).getTitleProperty().set("__force change of value");
                taskDisplayList.get(k).getTitleProperty().set(tmp);

                Scheduler.taskDisplayList.get(k).getTitleProperty().removeListener(list);
            }
            catch(IndexOutOfBoundsException e)
            {
                /*wykorzystanie polimorfizmu*/
                taskDisplayList.add(new EventNull());

                mainStageController.update.updateIndex(k);
            }
        }
    }

    public static void init()
    {
        try {Database.getInstance().sort();}
        catch (IndexOutOfBoundsException e) {}

        currentPage=0;

        taskDisplayList.clear();
        for (int i=0;i<3;i++)
        {
            try {taskDisplayList.add(Database.getInstance().get(i));}
            catch(IndexOutOfBoundsException e) {taskDisplayList.add(new EventNull());}
        }
    }

    public void getNextPage()
    {
        currentPage+=1;

        //Sprawdzenie, czy kolejna rozpoczęta strona istnieje
        try {Database.getInstance().get(currentPage*3-3);}
        catch (IndexOutOfBoundsException e) {currentPage-=1;}
        update();
    }

    public void getPrevPage()
    {
        currentPage-=1;
        if (currentPage<1)
            currentPage=1;
        update();
    }
}
