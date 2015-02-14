package com.example.deltahacks.walksafe;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Created by faye on 2015-02-14.
 */
public class ContactManager implements Serializable{

    private HashSet<Contact> contacts;

    public ContactManager(){
        this.contacts = new HashSet<Contact>();

    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public HashSet<Contact> getContacts() {
        return this.contacts;
    }


}
