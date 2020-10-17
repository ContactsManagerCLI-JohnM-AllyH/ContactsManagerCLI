package menu;

import contacts.ContactsManager;
import input.Input;

import java.util.Arrays;

public class Add extends MenuItem {

    public Add() {
        setDescription("Add a contact");
    }

    @Override
    public void action() {
        String name = Input.getString("Enter the contact's name");
        String phone = Input.getString("Enter the phone number");

        ContactsManager.addData(Arrays.asList(name, phone));
        ContactsManager.saveData();
        System.out.println("\nAdded " + name + " to the contact list\n");
    }

    @Override
    public boolean isAvailable() {
        return ContactsManager.numberOfContacts() < Integer.MAX_VALUE;
    }
}
