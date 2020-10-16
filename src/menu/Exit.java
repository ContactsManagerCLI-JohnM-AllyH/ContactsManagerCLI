package menu;

public class Exit extends MenuItem {


    public Exit() {
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
