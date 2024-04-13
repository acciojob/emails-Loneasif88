package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
    	super(emailId, Integer.MAX_VALUE);
    	this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
    	calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
    	//Collections.sort(calendar);
    	/*int maxMeetings = 0;
    	Meeting previousMeeting = null;
    	
    	for(Meeting meeting : calendar) {
    		if(previousMeeting == null || meeting.getStartTime().compareTo(previousMeeting.getEndTime())>=0) {
    			maxMeetings++;
    			previousMeeting = meeting;
    		}
    	}
    	return maxMeetings;*/
    	
    	if (calendar.isEmpty()) {
            return 0;
        }

        // Sort meetings by start time
        Collections.sort(calendar, Comparator.comparing(Meeting::getStartTime));

        int maxMeetings = 1;
        LocalTime endTime = calendar.get(0).getEndTime();

        // Iterate through meetings
        for (int i = 1; i < calendar.size(); i++) {
            Meeting currentMeeting = calendar.get(i);
            LocalTime currentStartTime = currentMeeting.getStartTime();

            // Check if current meeting starts after the end time of the last attended meeting
            if (currentStartTime.compareTo(endTime) > 0) {
                maxMeetings++;
                endTime = currentMeeting.getEndTime(); // Update end time
            }
        }

        return maxMeetings;

    }
}
