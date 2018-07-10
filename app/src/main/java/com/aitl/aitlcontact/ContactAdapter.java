package com.aitl.aitlcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    List<MyContact> contactList;
    Context context;

    ContactAdapter(Context context, List<MyContact> contactList){
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        MyContact myContact = contactList.get(position);
        ViewHodler holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.contact_item, parent, false);
            holder = new ViewHodler();
            holder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.textViewNumber = (TextView) convertView.findViewById(R.id.textViewNumber);

            convertView.setTag(holder);
        } else {
            holder = (ViewHodler) convertView.getTag();
        }


        holder.textViewName.setText(myContact.getContactName());
        holder.textViewNumber.setText(myContact.getContactNumber());


        return convertView;
    }

    private class ViewHodler{
        public TextView textViewName;
        public TextView textViewNumber;
    }
}
