package com.example.deltahacks.walksafe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Judy on 2015-02-14.
 */
public class JourneyManager implements Serializable {
    private ArrayList<Journey> journeyList;

    public JourneyManager(){
       this.journeyList = new ArrayList<Journey>();
       Journey set_10 = new Journey("10 min", "", 10);
       Journey set_20 = new Journey("20 min", "", 20);
       Journey set_30 = new Journey("30 min", "", 30);
       this.journeyList.add(set_10);
       this.journeyList.add(set_20);
       this.journeyList.add(set_30);

    }

    public void addJourney(Journey journey){
        if (!Arrays.asList(journeyList).contains(journey)){
            this.journeyList.add(journey);
        }
    }

    public void deleteContact(Journey journey){
        this.journeyList.remove(journey);
    }

    public void updateJourney(int index, String start, String end, int duration) {
        Journey journey = this.journeyList.get(index);
        if (start != null || end != null) {
            journey.setJourney(start, end);
        }
        if (duration > 0) {
            journey.setDuration(duration);
        }
    }
}
