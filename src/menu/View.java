package menu;

public class View extends MenuItem {

    public View() {
        setDescription("View contacts");
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void action() {

    }
}
