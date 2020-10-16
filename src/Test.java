public class Test {
    public static void main(String[] args) {
        Contact ally = new Contact("Ally", "210-000-0000");
        Contact john = new Contact("John", "512-000-0000");
        Contact luna = new Contact("Luna", "890-000-0000");
        Contact liz = new Contact("Liz", "900-000-0000");
//        System.out.println(ally.getContactInfo());
//        System.out.println(john.getContactInfo());

        ContactsManager contactList = new ContactsManager();
        contactList.addContact(ally);
        contactList.addContact(john);
        contactList.addContact(luna);
        contactList.addContact(liz);
        contactList.printContacts();
        System.out.println();

        contactList.deleteContact("aLlY");
        System.out.println(contactList.hasContact("kai"));
        System.out.println(contactList.hasPhoneNumber("890-900-0000"));
        contactList.printContacts();


    }


}
