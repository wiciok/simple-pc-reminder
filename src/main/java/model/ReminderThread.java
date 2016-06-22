package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class ReminderThread
{
	public static Task<Void> task = new Task<Void>()
				{
					protected Void call() throws Exception
					{
						System.out.println(Integer.toString(Database.getInstance().size()));
						check();
						return null;
					}
				};
				
	public void taskStop()
	{
		task.cancel();
	}
	
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
						alert.setTitle("INFORMATION");
						alert.setHeaderText("Event remainder alert!");
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
