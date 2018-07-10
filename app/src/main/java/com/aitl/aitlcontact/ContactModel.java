package com.aitl.aitlcontact;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class ContactModel {
    public static ArrayList<MyContact> getAllContacts(Context context) {
        ArrayList<MyContact> contactList = new ArrayList<>();

        Uri uri = ContactsContract.Contacts.CONTENT_URI; // Contact URI
        Cursor contactsCursor = context.getContentResolver().query(uri, null, null,
                null, ContactsContract.Contacts.DISPLAY_NAME + " ASC "); // Return

        if (contactsCursor.moveToFirst()) {
            do {
                long contctId = contactsCursor.getLong(contactsCursor.getColumnIndex("_ID")); // Get contact ID
                Uri dataUri = ContactsContract.Data.CONTENT_URI; // URI to get
                // data of contacts
                Cursor dataCursor = context.getContentResolver().query(dataUri, null,
                        ContactsContract.Data.CONTACT_ID + " = " + contctId,
                        null, null);// Retrun data cusror represntative to
                // contact ID

                // Strings to get all details
                String displayName = "Not Found";
                String homePhone = "";
                String mobilePhone = "";
                String workPhone = "";

                // This strings stores all contact numbers, email and other
                // details like nick name, company etc.
                String contactNumbers = "";

                // Now start the cusrsor
                if (dataCursor.moveToFirst()) {
                    displayName = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));// get

                    do {

                        if (dataCursor.getString(dataCursor.getColumnIndex("mimetype"))
                                .equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)) {

                            // In this get All contact numbers like home,
                            // mobile, work, etc and add them to numbers string
                            switch (dataCursor.getInt(dataCursor.getColumnIndex("data2"))) {
                                case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                                    homePhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                    contactNumbers += "Home Phone : " + homePhone + "\n";
                                    break;

                                case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                                    workPhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                    contactNumbers += "Work Phone : " + workPhone + "\n";
                                    break;

                                case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                    mobilePhone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                                    contactNumbers += "Mobile Phone : " + mobilePhone + "\n";
                                    break;

                            }
                        }

                    } while (dataCursor.moveToNext()); // Now move to next
                    // cursor

                    MyContact myContact = new MyContact(Long.toString(contctId));
                    myContact.setContactName(displayName);
                    myContact.setContactNumber(contactNumbers);
                    contactList.add(myContact);// Finally add items to array list
                }

            } while (contactsCursor.moveToNext());
        }
        return contactList;
    }
}
