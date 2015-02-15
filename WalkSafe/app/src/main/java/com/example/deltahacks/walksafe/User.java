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
    private CheckBox One, Two, Three, Four, Five;
    private Runnable checkAgainSignal;

    /**
     * methods
     */
    public User(){
        Handler handler = new Handler();
        Runnable checkAgainSignal = new Runnable() {
            @Override
            public void run() {
                checkAgain();
            }
        };
    }

    public void start(Journey journey){
        if (checkBoxCheck())
        {
            timeKeeper.postDelayed(checkAgainSignal,journey.getDuration()*1000*60);
        }
    }

    public boolean checkBoxCheck(){
        boolean Checked = false;
        if (One.isChecked() || Two.isChecked() || Three.isChecked() || Four.isChecked() ||Five.isChecked())
        {
            Checked = true;
        }
        return Checked;
    }

    public void startPanic(){
        timeKeeper.removeCallbacks(checkAgainSignal);

    }

    public void gotHome(){
        timeKeeper.removeCallbacks(checkAgainSignal);
    }

    public void checkAgain(){
        /**
         * display alert screen
         */
    }

    public void addMoreTime(){
        /**
         * call when user selects add more time default 5 seconds
         */
        timeKeeper.postDelayed(checkAgainSignal,5*1000*60);
    }
}

