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

    public void deleteContact(Contact contact){
        this.contacts.remove(contact);
    }

    public void updateContact(String name){
        for (Contact contact: this.getContacts()){
            if (contact.getContactName() == name){

            }

        }

    }

    public HashSet<Contact> getContacts() {
        return this.contacts;
    }


}
