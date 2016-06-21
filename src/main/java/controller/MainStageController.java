package controller;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Scheduler;
import view.AddEventStage;
import view.MainStage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Witek
 * Klasa kontrolera gównej sceny (okna)
 *
 * ToDo: refaktoryzacja, dekompozycja zależności
 */
public class MainStageController implements Initializable
{
    private MainStage mainApp;
    public MainStageController(){}
    //ToDo: modyfikatory dostępu
    public AddEventStage addEventStage;
    public Scheduler scheduler;

    public UpdateAdapter update = new UpdateAdapter();


    //robię to tutaj, żeby była dekompozycja zależności i dało się to łatwo zmienić
    String buttonCloseText = new String("Close");
    String buttonAddText = new String("Add Event");
    String buttonNextEventsText = new String("Next");
    String buttonPrevEventsText = new String("Previous");
    String buttonRefreshText = new String("Refresh");


    //jeśli w SceneBuilderze nadaliśmy kontrolce takie samo ID jak nazwa obiektu
    //to zostaną one automatycznie połączone - do zmiennej obiektowej zostanie przypisany obiekt
    //potrzebna jest do tego oczywiscie adnotacja @FXML
    @FXML
    private TitledPane paneEvent1;
    @FXML
    private TitledPane paneEvent2;
    @FXML
    private TitledPane paneEvent3;
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonNextEvents;
    @FXML
    private Button buttonPrevEvents;
    @FXML
    private Button buttonRefresh;
    @FXML
    private Label labelEvent1Category;
    @FXML
    private Label labelEvent2Category;
    @FXML
    private Label labelEvent3Category;


    public void initialize(URL url, ResourceBundle rb)
    {
        //konstruktor Schedulera - ważne! połączenie pomiędzy schedulerem a controllerem
        scheduler=new Scheduler(this);


        buttonClose.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
               mainApp.mainStage.close();
            }
        });
        
        buttonAdd.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                addEventStage = new AddEventStage(mainApp);
            }
        });

        buttonNextEvents.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                scheduler.getNext();
            }
        });

        buttonPrevEvents.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                scheduler.getPrev();
            }
        });

        buttonRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scheduler.update();
            }
        });

        buttonClose.setText(buttonCloseText);
        buttonAdd.setText(buttonAddText);
        buttonPrevEvents.setText(buttonPrevEventsText);
        buttonNextEvents.setText(buttonNextEventsText);
        buttonRefresh.setText(buttonRefreshText);

        paneEvent1.setText(Scheduler.taskDisplayList.get(0).getTitle());
        paneEvent2.setText(Scheduler.taskDisplayList.get(1).getTitle());
        paneEvent3.setText(Scheduler.taskDisplayList.get(2).getTitle());

        labelEvent1Category.setText(Scheduler.taskDisplayList.get(0).getCategory());
        labelEvent2Category.setText(Scheduler.taskDisplayList.get(1).getCategory());
        labelEvent3Category.setText(Scheduler.taskDisplayList.get(2).getCategory());
    }

    public void setMainApp(MainStage mainApp)
    {
        this.mainApp = mainApp;
    }


    /**
     * Klasa wewętrzna stanowiąca adapter do wywoływania metod
     * Wzorzec projektowy Adapter.
     */
    public class UpdateAdapter
    {
        public void update1(String s)
        {
            paneEvent1.setText(s);
            System.out.println("controller.update1");
            System.out.println(s);
        }
        public void update2(String s)
        {
            paneEvent2.setText(s);
            System.out.println("controller.update2");
            System.out.println(s);
        }
        public void update3(String s)
        {
            paneEvent3.setText(s);
            System.out.println("controller.update3");
            System.out.println(s);
        }

        public abstract class Update
        {
            public abstract void updateIndex(int index, String s);
        }

        private Update[] updateArr = new UpdateAdapter.Update[]
        {
            new UpdateAdapter.Update() { public void updateIndex(int index, String s) { update1(s); } },
            new UpdateAdapter.Update() { public void updateIndex(int index, String s) { update2(s); } },
            new UpdateAdapter.Update() { public void updateIndex(int index, String s) { update3(s); } }
        };

        public void updateIndex(int index, String s)
        {
            updateArr[index].updateIndex(index, s);
        }
    }
}