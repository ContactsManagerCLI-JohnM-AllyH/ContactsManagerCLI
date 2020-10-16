import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {

//        ContactsManager contactList = new ContactsManager("Ally", "210-000-000",
//                "John", "512-000-0000",
//                "Luna", "890-000-0000",
//                "Liz", "900-000-0000");

        ContactsManager contactList = new ContactsManager("init.txt");

        contactList.printContacts();
        System.out.println();

        contactList.deleteContact("aLlY");
        System.out.println(contactList.hasContact("kai"));
        System.out.println(contactList.hasPhoneNumber("890-900-0000"));
        contactList.printContacts();


    }


}
