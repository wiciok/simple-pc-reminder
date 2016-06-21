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
 * Klasa kontrolera głównej sceny (okna)
 */
public class MainStageController implements Initializable
{
    private MainStage mainApp;
    public MainStageController(){}
    private AddEventStage addEventStage;
    Scheduler scheduler;

    public UpdateAdapter update = new UpdateAdapter();


    /*jeśli w SceneBuilderze nadaliśmy kontrolce takie samo ID jak nazwa obiektu
    to zostaną one automatycznie połączone - do zmiennej obiektowej zostanie przypisany obiekt
    potrzebna jest do tego oczywiscie adnotacja @FXML
    */

    @FXML private TitledPane paneEvent1;
    @FXML private TitledPane paneEvent2;
    @FXML private TitledPane paneEvent3;
    @FXML private Button buttonClose;
    @FXML private Button buttonAdd;
    @FXML private Button buttonNextEvents;
    @FXML private Button buttonPrevEvents;
    @FXML private Button buttonRefresh;
    @FXML private Label pageLabel;
    @FXML private Label labelEvent1Category;
    @FXML private Label labelEvent2Category;
    @FXML private Label labelEvent3Category;


    public void initialize(URL url, ResourceBundle rb)
    {
        //konstruktor Schedulera - ważne! połączenie pomiędzy schedulerem a controllerem
        scheduler=new Scheduler(this);


        buttonClose.setOnAction(event -> mainApp.mainStage.close());

        buttonAdd.setOnAction(event -> addEventStage = new AddEventStage(mainApp));

        buttonNextEvents.setOnAction(event -> {
            scheduler.getNext();
            pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));
        });
        buttonPrevEvents.setOnAction(event -> {
            scheduler.getPrev();
            pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));
        });
        buttonRefresh.setOnAction(event -> {
            scheduler.update();
            pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));
        });

        buttonClose.setText(Resources.MainStageRes.buttonCloseText);
        buttonAdd.setText(Resources.MainStageRes.buttonAddText);
        buttonPrevEvents.setText(Resources.MainStageRes.buttonPrevEventsText);
        buttonNextEvents.setText(Resources.MainStageRes.buttonNextEventsText);
        buttonRefresh.setText(Resources.MainStageRes.buttonRefreshText);
        pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));

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
     * ToDo: println do wywalenia po zakonczniu pracy nad klasą Scheduler
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