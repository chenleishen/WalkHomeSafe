package com.example.deltahacks.walksafe;

import java.io.Serializable;
import android.os.Handler;
import android.widget.CheckBox;

/**
 * Created by Judy on 2015-02-14.
 */
public class User implements Serializable {
    /**
     * attributes
     */
    private Handler timeKeeper;

    public User(){
        timeKeeper = new Handler();
    }

    public void start(int journeyNum, Runnable check){
            timeKeeper.postDelayed(check, (journeyNum+1)*1000);
    }

    public void startPanic(Runnable check){
        timeKeeper.removeCallbacks(check);

    }

    public void gotHome(Runnable check){
        timeKeeper.removeCallbacks(check);
    }


    public void addMoreTime(Runnable check){
        /**
         * call when user selects add more time default 5 seconds
         */
        timeKeeper.postDelayed(check,5*1000*60);
    }
}

