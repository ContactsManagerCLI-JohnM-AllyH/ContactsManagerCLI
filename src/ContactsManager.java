import java.util.HashMap;

public class ContactsManager {

    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact){
        contacts.put(contact.getName(), contact);
    }

    public void printContacts(){
        for(String name: contacts.keySet()) {
            System.out.println(contacts.get(name).getContactInfo());
        }
    }

    public void deleteContact(){

    }
}
