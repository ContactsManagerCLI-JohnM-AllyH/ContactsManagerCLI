package menu;

public class Add extends MenuItem {

    public Add() {
        setDescription("Add a contact");
    }

    @Override
    public void action() {
        System.out.println("Add action()");
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

}
