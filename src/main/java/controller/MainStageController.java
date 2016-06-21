package controller;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Scheduler;
import view.AddEventStage;
import view.MainStage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * @author Witek
 * Klasa kontrolera głównej sceny (okna)
 * 
 * ToDo: zastananowic sie, czy rzeczy niezwiaznych bezposrednio z coltrollerem nie przeniesc do view (zmiana na public)
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
    @FXML private Button buttonRemove;
    @FXML private Label pageLabel;

    /*LABELE OGOLNE*/
    @FXML private Label descriptionLabel1;
    @FXML private Label categoryLabel1;
    @FXML private Label titleLabel1;
    @FXML private Label startDateTime1;
    @FXML private Label endDateTime1;
    @FXML private Label alertFrequency1;
    @FXML private Label priority1;
    @FXML private Label isActive1;

    @FXML private Label descriptionLabel2;
    @FXML private Label categoryLabel2;
    @FXML private Label titleLabel2;
    @FXML private Label startDateTime2;
    @FXML private Label endDateTime2;
    @FXML private Label alertFrequency2;
    @FXML private Label priority2;
    @FXML private Label isActive2;

    @FXML private Label descriptionLabel3;
    @FXML private Label categoryLabel3;
    @FXML private Label titleLabel3;
    @FXML private Label startDateTime3;
    @FXML private Label endDateTime3;
    @FXML private Label alertFrequency3;
    @FXML private Label priority3;
    @FXML private Label isActive3;

    /*LABELE ZALEZNE*/
    @FXML private Label labelEvent1Description;
    @FXML private Label labelEvent1Category;
    @FXML private Label labelEvent1Title;
    @FXML private Label labelEvent1StartDateTime;
    @FXML private Label labelEvent1EndDateTime;
    @FXML private Label labelEvent1AlertFrequency;
    @FXML private Label labelEvent1Priority;
    @FXML private Label labelEvent1IsActive;

    @FXML private Label labelEvent2Description;
    @FXML private Label labelEvent2Category;
    @FXML private Label labelEvent2Title;
    @FXML private Label labelEvent2StartDateTime;
    @FXML private Label labelEvent2EndDateTime;
    @FXML private Label labelEvent2AlertFrequency;
    @FXML private Label labelEvent2Priority;
    @FXML private Label labelEvent2IsActive;

    @FXML private Label labelEvent3Description;
    @FXML private Label labelEvent3Category;
    @FXML private Label labelEvent3Title;
    @FXML private Label labelEvent3StartDateTime;
    @FXML private Label labelEvent3EndDateTime;
    @FXML private Label labelEvent3AlertFrequency;
    @FXML private Label labelEvent3Priority;
    @FXML private Label labelEvent3IsActive;

    /*LINIE*/
    @FXML private Line descriptionLine;
    @FXML private Line categoryLine;
    @FXML private Line titleLine;
    
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
        buttonRemove.setText(Resources.MainStageRes.buttonRemoveText);
        pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));

        paneEvent1.setText(Scheduler.taskDisplayList.get(0).getTitle());
        paneEvent2.setText(Scheduler.taskDisplayList.get(1).getTitle());
        paneEvent3.setText(Scheduler.taskDisplayList.get(2).getTitle());

        /*LABELE OGOLNE*/
        descriptionLabel1.setText(Resources.MainStageRes.descriptionLabelText);
        categoryLabel1.setText(Resources.MainStageRes.categoryLabelText);
        titleLabel1.setText(Resources.MainStageRes.titleLabelText);
        startDateTime1.setText(Resources.MainStageRes.startDateTimeText);
        endDateTime1.setText(Resources.MainStageRes.endDateTimeText);
        alertFrequency1.setText(Resources.MainStageRes.alertFrequencyText);
        priority1.setText(Resources.MainStageRes.priorityText);
        isActive1.setText(Resources.MainStageRes.isActiveText);

        descriptionLabel2.setText(Resources.MainStageRes.descriptionLabelText);
        categoryLabel2.setText(Resources.MainStageRes.categoryLabelText);
        titleLabel2.setText(Resources.MainStageRes.titleLabelText);
        startDateTime2.setText(Resources.MainStageRes.startDateTimeText);
        endDateTime2.setText(Resources.MainStageRes.endDateTimeText);
        alertFrequency2.setText(Resources.MainStageRes.alertFrequencyText);
        priority2.setText(Resources.MainStageRes.priorityText);
        isActive2.setText(Resources.MainStageRes.isActiveText);

        descriptionLabel3.setText(Resources.MainStageRes.descriptionLabelText);
        categoryLabel3.setText(Resources.MainStageRes.categoryLabelText);
        titleLabel3.setText(Resources.MainStageRes.titleLabelText);
        startDateTime3.setText(Resources.MainStageRes.startDateTimeText);
        endDateTime3.setText(Resources.MainStageRes.endDateTimeText);
        alertFrequency3.setText(Resources.MainStageRes.alertFrequencyText);
        priority3.setText(Resources.MainStageRes.priorityText);
        isActive3.setText(Resources.MainStageRes.isActiveText);

        /*LABELE SZCZEGOLOWE*/
        labelEvent1IsActive.setText(String.valueOf(Scheduler.taskDisplayList.get(0).getIsActive()));
        labelEvent1Priority.setText(Integer.toString(Scheduler.taskDisplayList.get(0).getPriority()));
        labelEvent1AlertFrequency.setText(Integer.toString(Scheduler.taskDisplayList.get(0).getAlertFrequency()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        labelEvent1StartDateTime.setText(Scheduler.taskDisplayList.get(0).getEventFullDateStart().format(formatter));
        labelEvent1EndDateTime.setText(Scheduler.taskDisplayList.get(0).getEventFullDateEnd().format(formatter));
        labelEvent1Title.setText(Scheduler.taskDisplayList.get(0).getTitle());
        labelEvent1Category.setText(Scheduler.taskDisplayList.get(0).getCategory());
        labelEvent1Description.setAlignment(Pos.TOP_LEFT);
        labelEvent1Description.setWrapText(true);
        labelEvent1Description.setText(Scheduler.taskDisplayList.get(0).getDescription());

        labelEvent2IsActive.setText(String.valueOf(Scheduler.taskDisplayList.get(1).getIsActive()));
        labelEvent2Priority.setText(Integer.toString(Scheduler.taskDisplayList.get(1).getPriority()));
        labelEvent2AlertFrequency.setText(Integer.toString(Scheduler.taskDisplayList.get(1).getAlertFrequency()));
        labelEvent2StartDateTime.setText(Scheduler.taskDisplayList.get(1).getEventFullDateStart().format(formatter));
        labelEvent2EndDateTime.setText(Scheduler.taskDisplayList.get(1).getEventFullDateEnd().format(formatter));
        labelEvent2Title.setText(Scheduler.taskDisplayList.get(1).getTitle());
        labelEvent2Category.setText(Scheduler.taskDisplayList.get(1).getCategory());
        labelEvent2Description.setAlignment(Pos.TOP_LEFT);
        labelEvent2Description.setWrapText(true);
        labelEvent2Description.setText(Scheduler.taskDisplayList.get(1).getDescription());

        labelEvent3IsActive.setText(String.valueOf(Scheduler.taskDisplayList.get(2).getIsActive()));
        labelEvent3Priority.setText(Integer.toString(Scheduler.taskDisplayList.get(2).getPriority()));
        labelEvent3AlertFrequency.setText(Integer.toString(Scheduler.taskDisplayList.get(2).getAlertFrequency()));
        labelEvent3StartDateTime.setText(Scheduler.taskDisplayList.get(2).getEventFullDateStart().format(formatter));
        labelEvent3EndDateTime.setText(Scheduler.taskDisplayList.get(2).getEventFullDateEnd().format(formatter));
        labelEvent3Title.setText(Scheduler.taskDisplayList.get(2).getTitle());
        labelEvent3Category.setText(Scheduler.taskDisplayList.get(2).getCategory());
        labelEvent3Description.setAlignment(Pos.TOP_LEFT);
        labelEvent3Description.setWrapText(true);
        labelEvent3Description.setText(Scheduler.taskDisplayList.get(2).getDescription());
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