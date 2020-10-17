package menu;

public class Exit extends MenuItem {


    public Exit() {
        setDescription("Exit");
    }

    @Override
    public void action() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }


}
