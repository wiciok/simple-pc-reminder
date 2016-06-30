package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Database;
import model.Scheduler;
import view.*;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * @author Witold Karaś
 * @author Paweł Kapuśniak
 * Klasa kontrolera głównej sceny (okna)
 * todo: refaktoryzacja
 */

public class MainStageController implements Initializable
{
    private MainStage mainApp;
    public MainStageController(){}
    private AddEventStage addEventStage;
    private PropertiesStage propertiesStage;
    Scheduler scheduler;

    public UpdateAdapter update = new UpdateAdapter();


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
    @FXML public Label mainLabel;

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
            scheduler.getNextPage();
            pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));
        });
        buttonPrevEvents.setOnAction(event -> {
            scheduler.getPrevPage();
            pageLabel.setText(Resources.MainStageRes.pageLabelText+Integer.toString(Scheduler.currentPage));
        });

        /*rozwijanie i zwijanie okna*/
        buttonResize.setOnAction(event -> {
            if(!mainApp.expanded)
            {
                mainApp.mainStage.setHeight(550);
                mainApp.expanded=true;
                buttonResize.setText(Resources.MainStageRes.buttonResizeTextHide);
            }
            else
            {
                mainApp.mainStage.setHeight(85);
                mainApp.expanded=false;
                buttonResize.setText(Resources.MainStageRes.buttonResizeTextShow);
            }
        });

        /*usuwanie eventów + bezpośrednie odświeżanie głównej sceny*/
        buttonRemove1.setOnAction(event -> removeEventAndUpdateMainStage(0));
        buttonRemove2.setOnAction(event -> removeEventAndUpdateMainStage(1));
        buttonRemove3.setOnAction(event -> removeEventAndUpdateMainStage(2));
    }
    private void removeEventAndUpdateMainStage(final int slotNumber)
    {
        try
        {
            Database.getInstance().remove(3*(Scheduler.currentPage-1)+slotNumber);
            for (int i=slotNumber;i<3;i++)
            {
                update.updateIndex(i);
                scheduler.update();
            }
            update.updateIndex(slotNumber);
            scheduler.update();
        }
        catch (IndexOutOfBoundsException exception) {new ExceptionAlert(Alert.AlertType.WARNING,"Event does not exist!");}
    }

    public void setMainApp(MainStage mainApp) {this.mainApp = mainApp;}

    
    /**
     * @author Witold Karaś
     * Klasa wewętrzna stanowiąca adapter do wywoływania metod
     * Implementacja wzorca projektowego Adapter.
     */
    public class UpdateAdapter
    {
        private void update(int slotNumber)
        {
            paneEvent1.setText(Scheduler.taskDisplayList.get(slotNumber).getTitle());
            labelEvent1Description.setText(Scheduler.taskDisplayList.get(slotNumber).getDescription());
            labelEvent1Category.setText(Scheduler.taskDisplayList.get(slotNumber).getCategory());
            labelEvent1Title.setText(Scheduler.taskDisplayList.get(slotNumber).getTitle());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            labelEvent1StartDateTime.setText(Scheduler.taskDisplayList.get(slotNumber).getEventFullDateStart().format(formatter));
            labelEvent1EndDateTime.setText(Scheduler.taskDisplayList.get(slotNumber).getEventFullDateEnd().format(formatter));
            labelEvent1AlertFrequency.setText(Scheduler.taskDisplayList.get(slotNumber).getAlertFrequency().toString());
            labelEvent1Priority.setText(Scheduler.taskDisplayList.get(slotNumber).getPriority().toString());
            labelEvent1IsActive.setText(Scheduler.taskDisplayList.get(slotNumber).getIsActive().toString());
        }

        abstract class Update {public abstract void updateIndex(int index);}

        private Update[] updateArr = new UpdateAdapter.Update[]
        {
            new UpdateAdapter.Update() { public void updateIndex(int index) { update(0); } },
            new UpdateAdapter.Update() { public void updateIndex(int index) { update(1); } },
            new UpdateAdapter.Update() { public void updateIndex(int index) { update(2); } }
        };

        public void updateIndex(int index)
        {
            updateArr[index].updateIndex(index);
        }
    }
}