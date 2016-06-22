package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Scheduler;
import view.AddEventStage;
import view.MainStage;
import view.Resources;

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

    /*inicjalizacja kontrolek na scenie - wiązanie z plikiem FXML
    * możliwe do wykonania jedynie w klasie kontrolera*/

    /*ELEMENTY STAŁE*/
    @FXML public TitledPane paneEvent1;
    @FXML public TitledPane paneEvent2;
    @FXML public TitledPane paneEvent3;
    @FXML public Button buttonClose;
    @FXML public Button buttonAdd;
    @FXML public Button buttonNextEvents;
    @FXML public Button buttonPrevEvents;
    @FXML public Button buttonRefresh;
    @FXML public Button buttonResize;
    @FXML public Label pageLabel;

    /*LABELE OGOLNE*/
    @FXML public Label descriptionLabel1;
    @FXML public Label categoryLabel1;
    @FXML public Label titleLabel1;
    @FXML public Label startDateTime1;
    @FXML public Label endDateTime1;
    @FXML public Label alertFrequency1;
    @FXML public Label priority1;
    @FXML public Label isActive1;

    @FXML public Label descriptionLabel2;
    @FXML public Label categoryLabel2;
    @FXML public Label titleLabel2;
    @FXML public Label startDateTime2;
    @FXML public Label endDateTime2;
    @FXML public Label alertFrequency2;
    @FXML public Label priority2;
    @FXML public Label isActive2;

    @FXML public Label descriptionLabel3;
    @FXML public Label categoryLabel3;
    @FXML public Label titleLabel3;
    @FXML public Label startDateTime3;
    @FXML public Label endDateTime3;
    @FXML public Label alertFrequency3;
    @FXML public Label priority3;
    @FXML public Label isActive3;

    /*LABELE ZALEZNE*/
    @FXML public Label labelEvent1Description;
    @FXML public Label labelEvent1Category;
    @FXML public Label labelEvent1Title;
    @FXML public Label labelEvent1StartDateTime;
    @FXML public Label labelEvent1EndDateTime;
    @FXML public Label labelEvent1AlertFrequency;
    @FXML public Label labelEvent1Priority;
    @FXML public Label labelEvent1IsActive;

    @FXML public Label labelEvent2Description;
    @FXML public Label labelEvent2Category;
    @FXML public Label labelEvent2Title;
    @FXML public Label labelEvent2StartDateTime;
    @FXML public Label labelEvent2EndDateTime;
    @FXML public Label labelEvent2AlertFrequency;
    @FXML public Label labelEvent2Priority;
    @FXML public Label labelEvent2IsActive;

    @FXML public Label labelEvent3Description;
    @FXML public Label labelEvent3Category;
    @FXML public Label labelEvent3Title;
    @FXML public Label labelEvent3StartDateTime;
    @FXML public Label labelEvent3EndDateTime;
    @FXML public Label labelEvent3AlertFrequency;
    @FXML public Label labelEvent3Priority;
    @FXML public Label labelEvent3IsActive;

    @FXML public Button buttonRemove1;
    @FXML public Button buttonRemove2;
    @FXML public Button buttonRemove3;


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
        buttonResize.setOnAction(event -> {
            if(mainApp.expanded==false)
            {
                mainApp.mainStage.setHeight(500);
                mainApp.expanded=true;
            }
            else
            {
                mainApp.mainStage.setHeight(85);
                mainApp.expanded=false;
            }
        });
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
        void update1(String s)
        {
            paneEvent1.setText(s);
            System.out.println("controller.update1");
            System.out.println(s);
        }
        void update2(String s)
        {
            paneEvent2.setText(s);
            System.out.println("controller.update2");
            System.out.println(s);
        }
        void update3(String s)
        {
            paneEvent3.setText(s);
            System.out.println("controller.update3");
            System.out.println(s);
        }

        abstract class Update
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