package menu;

public class Exit extends MenuItem {


    public Exit() {
        setDescription("Exit");
    }

    @Override
    public void action() {
        System.out.println("Exit action()");
    }

    @Override
    public boolean isAvailable() {
        return true;
    }


}
