package menu;

public class Search extends MenuItem {

    public Search() {
        setDescription("Search for a contact");
    }

    @Override
    public void action() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

}
