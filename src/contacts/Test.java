package contacts;

import input.Input;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        ContactsManager contactList = new ContactsManager("init.txt");

        String input = Input.getString();

        contactList.printContacts();
        System.out.println();
        contactList.deleteContact("aLlY");
        System.out.println(contactList.hasContact("kai"));
        System.out.println(contactList.hasPhoneNumber("890-900-0000"));
        contactList.printContacts();
    }


}
