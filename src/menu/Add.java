package menu;

public class Add extends MenuItem {

    public Add() {
        setDescription("Add Contact");
    }

    @Override
    public void action() {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

}
