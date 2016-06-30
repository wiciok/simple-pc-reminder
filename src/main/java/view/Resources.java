package view;

import javax.annotation.Resource;

/**
 * @author Witold Karaś on 2016-06-21.
 * Zdekomponowane zasoby wykorzystywanych w klasach controller
 */

@Resource
public class Resources
{
    public static class EventRes
    {
        /*Default values*/
        public static String defaultTitleText = "New Event";
        public static String defaultDescriptionText = "Empty";
        public static String defaultCategoryText = "Empty";
        public static String defaultIsActiveText = "True";
    }

    static class AddEventStageRes
    {
        static String stageTitle = "Add New Event";

        static String strTrue = "True";
        static String strFalse= "False";
        static String strCancel= "Cancel";
        static String strL1="Choose Event Priority";
        static String strL2="Choose Alert Frequency";
        static String strL3="Make Event Active?";
        static String strL4="Format HH:MM:SS or HH:MM";

        static String strPickStartDate="Choose Start Date";
        static String strPickEndDate="Choose End Date";

        static String strEventStartTime="Input Start Time";
        static String strEventEndTime="Input End Time";

        static String strEventDescriptionField="Input Event Description";
        static String strEventNameField="Input Event Name";
        static String strEventCategory="Input Event Category";

        static String strCreateEventButton = "Create Event";
    }

    static public class AddEventStageControllerRes
    {
        public static String evStartDateWar = "Event start date warning!";
        public static String noTimeOrWrongTimeFormat = "\"No time set or wrong format (HH:MM / HH:MM:SS)\\ne.g. 09:50, 17:30:22.\\n\\nCurrent time is set.\"";
        public static String noDateOrWrongDateFormat="No date set or the date is inproper.\n\nCurrent date will be set.";
    }

    public static class MainStageRes
    {
        static String buttonCloseText = "Close";
        static String buttonAddText = "Add Event";
        static String buttonNextEventsText = "Next";
        static String buttonPrevEventsText = "Previous";
        static String buttonRefreshText = "Refresh";
        static String buttonPropertiesText = "Properties";
        public static String buttonResizeTextShow = "Show";
        public static String buttonResizeTextHide = "Hide";
        public static String pageLabelText = "Page: ";
        static String buttonRemoveText = "Remove";

         /*STRINGI OD LABELI OGOLNYCH*/
        static String mainLabelText = "Events:";
        static String descriptionLabelText = "Description:";
        static String categoryLabelText = "Category:";
        static String titleLabelText = "Title:";
        static String startDateTimeText = "Start date and time:";
        static String endDateTimeText = "End date and time:";
        static String alertFrequencyText = "Alert frequency:";
        static String priorityText = "Priority:";
        static String isActiveText = "Is active?";
    }
    
    public static class PropertiesStageRes
    {
        static String exitButtonText = "Close"; 
        static String saveButtonText = "Save"; 
        
        /*LABELE*/
        static String howManyHoursLabelText = "Per how many hours show alert?";
        static String isActiveLabelText = "Make all events active?";
		static String titleLabelText = "Adjust default events";
		static String defaultNameText = "Default event name:";
		static String defaultCategoryText = "Default category:";
    }

    public static class AlertRes
    {
        public static String dbNotReadText ="Database File hasn't been read.";
        public static String stgError ="Stage Error!";
        public static String appTerminate="Application will be terminated.";
        public static String fileNotWritten="File has not been written on disc!";
        public static String stageClose="Stage will be closed.";
        public static String evDontExist="Event does not exist!";

        public static String remAlert="Event reminder alert!";
        public static String remText="Remember about upcoming event";
    }

}
