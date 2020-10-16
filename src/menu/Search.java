package menu;

public class Search extends MenuItem {

    public Search() {
        setDescription("This is how you exit.");
    }

    @Override
    public void action() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

}
