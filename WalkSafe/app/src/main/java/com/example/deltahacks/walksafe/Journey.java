package com.example.deltahacks.walksafe;

import java.io.Serializable;

/**
 * Created by Judy on 2015-02-14.
 */
public class Journey implements Serializable{
    private String label;
    /**
     * duration should be stored in units of minutes
     */
    private int duration;

    public Journey(String label, int duration) {
        this.label = label;
        this.duration = duration;
    }

    public int get_Duration(){
        return duration;
    }
}


