package com.example.deltahacks.walksafe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by faye on 2015-02-14.
 */
public class CustomAdapter extends ArrayAdapter<Contact> {

    private ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int textViewResourceId,
                           ArrayList<Contact> countryList) {
        super(context, textViewResourceId, countryList);
        this.contactList = new ArrayList<Contact>();
        this.contactList.addAll(countryList);
    }

    private class ViewHolder {
        CheckBox name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = LayoutInflater.from(parent.getContext());
            convertView = vi.inflate(R.layout.contact_list_item, null);

            holder = new ViewHolder();
            holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {

                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contactList.get(position);
        holder.name.setText(contact.getContactName());
        holder.name.setTag(contact);

        return convertView;

    }

}
