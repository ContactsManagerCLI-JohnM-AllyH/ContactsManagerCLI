package menu;

import contacts.ContactsManager;

public class View extends MenuItem {

    public View() {
        setDescription("View contacts");
    }

    @Override
    public boolean isAvailable() {
        return !ContactsManager.isEmpty();
    }

    @Override
    public void action() {
        System.out.println("View action()");
    }
}
