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
        Contact taylor = new Contact("Taylor Swift", "5194974336");
        Contact beyonce = new Contact("Beyonce", "6472428178");
        Contact ryan = new Contact("Ryan Gosling", "6472070816");
        Contact emma = new Contact("Emma Watson", "4167057272");
        Contact kanye = new Contact("Kanye West", "4168733662");
        this.contacts.add(taylor);
        this.contacts.add(beyonce);
        this.contacts.add(ryan);
        this.contacts.add(emma);
        this.contacts.add(kanye);
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
