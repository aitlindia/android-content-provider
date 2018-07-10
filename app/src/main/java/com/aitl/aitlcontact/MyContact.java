package com.aitl.aitlcontact;

public class MyContact {

	// Getter and setter for contacts
	private String contactId, contactName, contactNumber;

	public MyContact(String contactId) {
		this.contactId = contactId;
	}

    public MyContact(String contactId, String contactName, String contactNumber) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
