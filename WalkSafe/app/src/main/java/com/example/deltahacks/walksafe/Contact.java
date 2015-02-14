package com.example.deltahacks.walksafe;

import java.io.Serializable;

/**
 * Created by Judy on 2015-02-14.
 */
public class Contact implements Serializable {
    private String name;
    private String number;


    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public void setName(String name1){
        this.name = name1;
    }

    public void setNumber(String number1){
        this.number = number1;
    }

    public String getContactName() {
        return name;
    }

    public String getContactNumber() {
        return "+1" + number;
    }
}
