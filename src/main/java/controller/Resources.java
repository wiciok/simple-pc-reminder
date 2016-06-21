package controller;

import javax.annotation.Resource;

/**
 * Created by Witek on 2016-06-21.
 * Zdekomponowanie zasobów wykorzystywanych w klasach controller
 */

@Resource
class Resources
{
    static class AddEventStageRes
    {
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

    static class MainStageRes
    {
        static String buttonCloseText = "Close";
        static String buttonAddText = "Add Event";
        static String buttonNextEventsText = "Next";
        static String buttonPrevEventsText = "Previous";
        static String buttonRefreshText = "Refresh";
        static String pageLabelText = "Page: ";

        static String buttonRemoveText = "Remove";
 
         /*STRINGI OD LABELI OGOLNYCH*/
        static String descriptionLabelText = "Description:";
        static String categoryLabelText = "Category:";
        static String titleLabelText = "Title:";
        static String startDateTimeText = "Start date and time:";
        static String endDateTimeText = "End date and time:";
        static String alertFrequencyText = "Alert frequency:";
        static String priorityText = "Priority:";
        static String isActiveText = "Is active?";
        
    }

}
