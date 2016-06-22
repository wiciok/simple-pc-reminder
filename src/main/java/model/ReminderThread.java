package model;

import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by Paweł on 2016-06-19.
 *
 * Klasa zawierająca wątek odpowiedzialny za wyświetlanie przypomnień.
 * Ustawienia przypomnień konfigurowane są w klasie PropertiesStageController.
 */


public class ReminderThread
{
	public static Task<Void> task = new Task<Void>()
	{
		protected Void call() throws Exception
		{
			check();
			return null;
		}
	};
				
	public void taskStop() {task.cancel();}
	
	private static void check()
	{
		int timeMinutesNow;
		int timeHoursNow;
		int timeSecondsNow;
		
		if(task.isCancelled())
			return;
		
		while(true)
		{
			for(int i =0; i<Database.getInstance().size(); i++)
			{
				final int k = i;
				timeMinutesNow = LocalTime.now().getMinute();
				timeHoursNow = LocalTime.now().getHour();
				timeSecondsNow = LocalTime.now().getSecond();
				if(timeHoursNow % Database.getInstance().get(i).getAlertFrequency() == 0 && 
						timeMinutesNow == 0 && timeSecondsNow == 0 &&
						Database.getInstance().get(i).getIsActive() &&
						Database.getInstance().get(i).getEventFullDateStart().isAfter(LocalDateTime.now()))
				{
					Platform.runLater(() ->
					{
					    Alert alert = new Alert(AlertType.INFORMATION);
					    final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
		                if (runnable != null) 
		                    runnable.run();
						alert.setTitle("INFORMATION");
						alert.setHeaderText("Event reminder alert!");
						alert.setContentText("Remember about upcoming event \""+Database.getInstance().get(k).getTitle()+"\"");
						alert.showAndWait();
					});
				}
			}
			try
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				break;
			}
		}
	}
}
