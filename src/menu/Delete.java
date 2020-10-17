package menu;

import contacts.ContactsManager;

public class Delete extends MenuItem {

    public Delete() {
        setDescription("Delete a contact");
    }

    @Override
    public void action() {
        System.out.println("Delete action()");
    }

    @Override
    public boolean isAvailable() {
        return !ContactsManager.isEmpty();
    }
}
