package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    public ArrayList<Meeting> calender;

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();

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

        int maxMeetings = 0;
        for (Meeting meeting1 : calendar) {
            int count = 1;
            for (Meeting meeting2 : calendar) {
                if (meeting1 != meeting2) {
                    if (meeting2.getStartTime().compareTo(meeting1.getEndTime()) >= 0 || meeting2.getEndTime().compareTo(meeting1.getStartTime()) <= 0) {
                        count++;
                    }
                }
            }
            maxMeetings = Math.max(maxMeetings, count);
        }
        return maxMeetings;


    }
}
