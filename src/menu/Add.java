package menu;

public class Add extends MenuItem {

    public Add() {
        setDescription("Add a contact");
    }

    @Override
    public void action() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

}
