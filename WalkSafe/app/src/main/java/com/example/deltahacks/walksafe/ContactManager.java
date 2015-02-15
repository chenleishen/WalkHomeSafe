package com.example.deltahacks.walksafe;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * Created by faye on 2015-02-14.
 */

public class ContactManager implements Serializable{

    private ArrayList<Contact> contacts;

    public ContactManager(){
        this.contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);

    }

    public void deleteContact(String name) throws MissingContactException{
        for(Contact c : this.getContacts()){
            if(c.getContactName().equals(name)){
                this.contacts.remove(c);
            }
        }
        throw new MissingContactException();
    }

    public void updateContact(int index, String name, String number){
        Contact contact = this.contacts.get(index);
        if(name != null) {
            contact.setName(name);
        }
        if(number !=null) {
            contact.setNumber(number);
        }

    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }


}
