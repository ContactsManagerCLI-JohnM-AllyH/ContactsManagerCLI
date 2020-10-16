import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContactsManager {

    private final HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact){
        contacts.put(contact.getName().toLowerCase(), contact);
    }

    public ContactsManager(String fileName) throws IOException {
        Path path = Paths.get("data/" + fileName);
        List<String> fileContents = Files.readAllLines(path);
        addData(fileContents);
        System.out.println(fileContents.toString());
    }

    public ContactsManager(Path path) throws IOException {

        List<String> fileContents = Files.readAllLines(path);
        addData(fileContents);
        System.out.println(fileContents.toString());
    }

    public ContactsManager(String ...data) {
        addData(Arrays.asList(data));
    }

    public void addData(List<String> data) {
        for (short i = 0; i < data.size(); i += 2) {
            String name = data.get(i);
            String phoneNumber = data.get(i + 1);
            addContact(new Contact(name, phoneNumber));
        }
    }

    public void printContacts(){
        for(String name: contacts.keySet()) {
            System.out.println(contacts.get(name).getContactInfo());
        }
    }

    public void deleteContact(String name){
        contacts.remove(name.toLowerCase());
    }

    public boolean hasContact(String name) {
        return contacts.containsKey(name.toLowerCase());
    }

    public boolean hasPhoneNumber(String phoneNumber) {
        for(Contact contact : contacts.values()) {
            if(contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}