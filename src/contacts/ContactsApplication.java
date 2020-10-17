package contacts;

import menu.*;

import java.io.IOException;

public class ContactsApplication {

    public static void main(String[] args) throws IOException {
        ContactsManager.loadFromFile("init.txt");
        Menu.createMenu(new View(), new Add(), new Search(), new Delete(), new Exit());

        int option = Menu.getInput();
        Menu.runOption(option);

    }

}
