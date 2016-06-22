package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Database;
import model.Scheduler;
import view.AddEventStage;
import view.MainStage;
import view.PropertiesStage;
import view.Resources;

import java.net.URL;
import java.time.format.DateTimeFormatter;
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
    private PropertiesStage propertiesStage;
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
    @FXML public Button buttonResize;
    @FXML public Button propertiesButton;
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
        //konstruktor Schedulera - połączenie pomiędzy schedulerem a controllerem
        scheduler=new Scheduler(this);

        buttonClose.setOnAction(event -> mainApp.mainStage.close());
        buttonAdd.setOnAction(event -> addEventStage = new AddEventStage(mainApp));
        propertiesButton.setOnAction(event -> propertiesStage = new PropertiesStage(mainApp));
        buttonNextEvents.setOnAction(event -> {
            scheduler.getNext();
            pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));
        });
        buttonPrevEvents.setOnAction(event -> {
            scheduler.getPrev();
            pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));
        });

        /*rozwijanie i zwijanie okna*/
        buttonResize.setOnAction(event -> {
            if(mainApp.expanded==false)
            {
                mainApp.mainStage.setHeight(550);
                mainApp.expanded=true;
            }
            else
            {
                mainApp.mainStage.setHeight(85);
                mainApp.expanded=false;
            }
        });

        /*usuwanie eventów + bezpośrednie odświeżanie głównej sceny*/
        buttonRemove1.setOnAction(event ->
        {
            try
            {
                final int j = 0;
                Database.getInstance().remove(3*(Scheduler.currentPage-1)+j);
                for (int i=j;i<3;i++)
                {
                    update.updateIndex(i);
                    scheduler.update();
                }
                update.updateIndex(j);
                scheduler.update();
            }
            catch (IndexOutOfBoundsException exception)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Event does not exist!");
                alert.showAndWait();
            }
        });
        buttonRemove2.setOnAction(event ->
        {
            try
            {
                final int j = 1;
                Database.getInstance().remove(3*(Scheduler.currentPage-1)+j);
                for (int i=j;i<3;i++)
                {
                    update.updateIndex(i);
                    scheduler.update();
                }
                update.updateIndex(j);
                scheduler.update();
            }
            catch (IndexOutOfBoundsException exception)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Event does not exist!");
                alert.showAndWait();
            }
        });
        buttonRemove3.setOnAction(event ->
        {
            try
            {
                final int j = 2;
                Database.getInstance().remove(3*(Scheduler.currentPage-1)+j);
                for (int i=j;i<3;i++)
                {
                    update.updateIndex(i);
                    scheduler.update();
                }
                update.updateIndex(j);
                scheduler.update();
            }
            catch (IndexOutOfBoundsException exception)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Event does not exist!");
                alert.showAndWait();
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
     */
    public class UpdateAdapter
    {
        void update1()
        {
            paneEvent1.setText(Scheduler.taskDisplayList.get(0).getTitle());
            labelEvent1Description.setText(Scheduler.taskDisplayList.get(0).getDescription());
            labelEvent1Category.setText(Scheduler.taskDisplayList.get(0).getCategory());
            labelEvent1Title.setText(Scheduler.taskDisplayList.get(0).getTitle());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            labelEvent1StartDateTime.setText(Scheduler.taskDisplayList.get(0).getEventFullDateStart().format(formatter));
            labelEvent1EndDateTime.setText(Scheduler.taskDisplayList.get(0).getEventFullDateEnd().format(formatter));
            labelEvent1AlertFrequency.setText(Scheduler.taskDisplayList.get(0).getAlertFrequency().toString());
            labelEvent1Priority.setText(Scheduler.taskDisplayList.get(0).getPriority().toString());
            labelEvent1IsActive.setText(Scheduler.taskDisplayList.get(0).getIsActive().toString());
        }
        void update2()
        {
            paneEvent2.setText(Scheduler.taskDisplayList.get(1).getTitle());
            labelEvent2Description.setText(Scheduler.taskDisplayList.get(1).getDescription());
            labelEvent2Category.setText(Scheduler.taskDisplayList.get(1).getCategory());
            labelEvent2Title.setText(Scheduler.taskDisplayList.get(1).getTitle());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            labelEvent2StartDateTime.setText(Scheduler.taskDisplayList.get(1).getEventFullDateStart().format(formatter));
            labelEvent2EndDateTime.setText(Scheduler.taskDisplayList.get(1).getEventFullDateEnd().format(formatter));
            labelEvent2AlertFrequency.setText(Scheduler.taskDisplayList.get(1).getAlertFrequency().toString());
            labelEvent2Priority.setText(Scheduler.taskDisplayList.get(1).getPriority().toString());
            labelEvent2IsActive.setText(Scheduler.taskDisplayList.get(1).getIsActive().toString());
        }
        void update3()
        {
            //paneEvent3.setText(s);

            paneEvent3.setText(Scheduler.taskDisplayList.get(2).getTitle());
            labelEvent3Description.setText(Scheduler.taskDisplayList.get(2).getDescription());
            labelEvent3Category.setText(Scheduler.taskDisplayList.get(2).getCategory());
            labelEvent3Title.setText(Scheduler.taskDisplayList.get(2).getTitle());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            labelEvent3StartDateTime.setText(Scheduler.taskDisplayList.get(2).getEventFullDateStart().format(formatter));
            labelEvent3EndDateTime.setText(Scheduler.taskDisplayList.get(2).getEventFullDateEnd().format(formatter));
            labelEvent3AlertFrequency.setText(Scheduler.taskDisplayList.get(2).getAlertFrequency().toString());
            labelEvent3Priority.setText(Scheduler.taskDisplayList.get(2).getPriority().toString());
            labelEvent3IsActive.setText(Scheduler.taskDisplayList.get(2).getIsActive().toString());
        }

        abstract class Update
        {
            public abstract void updateIndex(int index);
        }

        private Update[] updateArr = new UpdateAdapter.Update[]
        {
            new UpdateAdapter.Update() { public void updateIndex(int index) { update1(); } },
            new UpdateAdapter.Update() { public void updateIndex(int index) { update2(); } },
            new UpdateAdapter.Update() { public void updateIndex(int index) { update3(); } }
        };

        public void updateIndex(int index)
        {
            updateArr[index].updateIndex(index);
        }
    }
}