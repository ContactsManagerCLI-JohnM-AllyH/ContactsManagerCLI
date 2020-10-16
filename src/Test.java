public class Test {
    public static void main(String[] args) {
        Contact ally = new Contact("Ally", "210-000-0000");
        Contact john = new Contact("John", "512-000-0000");
//        System.out.println(ally.getContactInfo());
//        System.out.println(john.getContactInfo());

        ContactsManager contactList = new ContactsManager();
        contactList.addContact(ally);
        contactList.addContact(john);
        contactList.printContacts();
    }


}
