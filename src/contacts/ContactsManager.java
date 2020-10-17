package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsManager {

    private static final HashMap<String, Contact> contacts = new HashMap<>();

    public static void addContact(Contact contact){
        contacts.put(contact.getName().toLowerCase(), contact);
    }

    public static void addData(List<String> data) {
        for (short i = 0; i < data.size(); i += 2) {
            String name = data.get(i);
            String phoneNumber = data.get(i + 1);
            addContact(new Contact(name, phoneNumber));
        }
    }

    public static void printContacts(){
        for(String name: contacts.keySet()) {
            System.out.println(contacts.get(name).getContactInfo());
        }
        System.out.println();
    }

    public static void deleteContact(String name){
        contacts.remove(name.toLowerCase());
    }

    public static boolean hasContact(String name) {
        return contacts.containsKey(name.toLowerCase());
    }

    public static boolean hasPhoneNumber(String phoneNumber) {
        for(Contact contact : contacts.values()) {
            if(contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty() {
        return contacts.size() == 0;
    }

    public static void loadFromFile(String fileName) throws IOException {
        Path path = Paths.get("data/" + fileName);
        List<String> fileContents = Files.readAllLines(path);
        addData(fileContents);
    }

    public static int numberOfContacts() {
        return contacts.size();
    }

    public static Set<String> keys() {
        return contacts.keySet();
    }

    public static Collection<Contact> values() {
        return contacts.values();
    }

    public static Contact getContact(String name) {
        return contacts.get(name);
    }

    public static void searchByName(String searchStr) {
        search(searchStr, "name");
    }

    public static void searchByNumber(String searchStr) {
        search(searchStr, "phoneNumber");
    }

    private static void search(String searchStr, String field) {
        ArrayList<Contact> results = new ArrayList<>();

        for (Contact contact: values()) {

            String str = field.equalsIgnoreCase("name") ? contact.getName() : contact.getPhoneNumber();

            if (str.toLowerCase().startsWith(searchStr)) {
                results.add(contact);
            }
        }

        System.out.printf("\n%d result%s for '%s'\n\n", results.size(), results.size() == 1 ? "" : "s", searchStr);

        for (Contact contact: results) {
            System.out.println(contact.getName() + " " + contact.getPhoneNumber());
        }

        System.out.println();
    }
}