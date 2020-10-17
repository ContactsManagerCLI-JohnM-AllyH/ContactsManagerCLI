package menu;

public class Delete extends MenuItem {

    public Delete() {
        setDescription("Delete a contact");
    }

    @Override
    public void action() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
