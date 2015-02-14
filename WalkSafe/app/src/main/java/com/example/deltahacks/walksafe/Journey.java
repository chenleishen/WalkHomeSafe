package com.example.deltahacks.walksafe;

import java.io.Serializable;

/**
 * Created by Judy on 2015-02-14.
 */
public class Journey implements Serializable{
    private String start;
    private String end;
    private String label;
    /**
     * duration should be stored in units of minutes
     */
    private int duration;

    public Journey(String start, String end, int duration) {
        this.start = start;
        this.end = end;
        this.label = "From " + start + " to " + end;
        this.duration = duration;
    }

    public void setDuration(int duration1){
        this.duration = duration1;
    }

    public void setJourney(String start, String end){
        this.start = start;
        this.end = end;
        this.label = "From " + start + " to " + end;
    }

    public int getDuration(){
        return duration;
    }

    public String getLabel(){
        return label;
    }
}


