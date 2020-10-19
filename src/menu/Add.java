package menu;

import contacts.Contact;
import contacts.ContactsManager;
import input.Input;

import java.io.Console;
import java.util.Arrays;

public class Add extends MenuItem {

    public Add() {
        setDescription("Add a contact");
    }

    @Override
    public void action() {
        String name = Input.getString("Enter the contact's name").trim();
        String phone;
        do {
            phone = Input.getString("Enter the phone number").trim();
            StringBuilder newPhone = new StringBuilder();

            for(char ch: phone.toCharArray()){
                byte ascii = (byte) ch;
                if(ascii >= 48 && ascii <= 57) {
                    newPhone.append(ch);
                }
            }

            if(!ContactsManager.isValidPhoneNumber(newPhone)){
                System.out.println("The phone number needs to be one of the following lengths:");
                for(byte number : ContactsManager.PHONE_LENGTHS){
                    System.out.println(number);
                }
            } else {
                break;
            }
        } while(true);


        if(!ContactsManager.hasContact(name)) {
            ContactsManager.addData(Arrays.asList(name, phone));
            ContactsManager.saveData();
            System.out.println("\nAdded " + name + " to the contact list\n");
        } else {
            String confirm = Input.getString(
                    String.format("There is already a contact with the name %s, do you want to overwrite it?\n[Y/N]", name)
            );
            System.out.println();
            if(confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
                ContactsManager.addContact(new Contact(name, phone));
            } else {
                System.out.println("\"Add contact\" cancelled ...\n");
            }

        }
    }

    @Override
    public boolean isAvailable() {
        return ContactsManager.numberOfContacts() < Integer.MAX_VALUE;
    }
}
