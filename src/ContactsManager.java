import java.util.HashMap;

public class ContactsManager {

    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact){
        contacts.put(contact.getName().toLowerCase(), contact);
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