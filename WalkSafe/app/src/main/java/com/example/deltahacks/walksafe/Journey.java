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

    public int get_Duration(){
        return duration;
    }

    public String get_Label(){
        return label;
    }
}


