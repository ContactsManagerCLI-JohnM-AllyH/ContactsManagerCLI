package contacts;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CyclicBarrier;

public class ContactsManager {
    //Text Colors for Console
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String RESET = "\033[0m";  // Text Reset

    public static final String FILE_NAME = "init.txt";

    private static final HashMap<String, Contact> contacts = new HashMap<>();

    public static final byte[] PHONE_LENGTHS = {10, 7};

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
        System.out.println(CYAN + "Name      " + YELLOW + "|" + CYAN + " Phone Number " + YELLOW + "|");
        System.out.println("--------------------------" + RESET);
        for(String name: contacts.keySet()) {
            System.out.printf("%-10s" + YELLOW + "| " + RESET, contacts.get(name).getName());
            System.out.printf("%-13s" + YELLOW + "|\n" + RESET,contacts.get(name).getPhoneNumber());
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

    public static boolean isNotEmpty() {
        return contacts.size() != 0;
    }

    public static void saveData() {
        System.out.println("\nSaving...\n");

        try {
            FileWriter myWriter = new FileWriter("data/" + FILE_NAME);
            for (Contact contact: values()) {
                myWriter.write(contact.getName() + "\n");
                myWriter.write(contact.getPhoneNumber() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("\nSave file missing\n");
        }
    }

    public static void loadFromFile(String fileName) throws IOException {
        Path path = Paths.get("data", fileName);

        if (Files.exists(path)) {
            List<String> fileContents = Files.readAllLines(path);
            addData(fileContents);
        } else {
            System.out.println("\nFile missing: creating new file\n");
            Files.createFile(path);
        }
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
        System.out.println(CYAN + "Name      " + YELLOW + "|" + CYAN + " Phone Number " + YELLOW + "|");
        System.out.println("--------------------------" + RESET);

        for (Contact contact: results) {
            System.out.printf("%-10s" + YELLOW + "| " + RESET, contact.getName());
            System.out.printf("%-13s" + YELLOW + "|\n" + RESET,contact.getPhoneNumber());
        }

        System.out.println();
    }

    public static boolean isValidPhoneNumber(StringBuilder number){
        for(byte length: PHONE_LENGTHS){
            if(number.length() == length){
                return true;
            }
        }
        return false;
    }
}