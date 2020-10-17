package menu;

import contacts.ContactsManager;

public class Search extends MenuItem {

    public Search() {
        setDescription("Search for a contact");
    }

    @Override
    public void action() {
        System.out.println("Search action()");
    }

    @Override
    public boolean isAvailable() {
        return !ContactsManager.isEmpty();
    }

}
