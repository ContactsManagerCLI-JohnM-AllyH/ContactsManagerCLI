package contacts;

import menu.*;

import java.io.IOException;

public class ContactsApplication {

    private static final String FILE_NAME = "init.txt";

    public static void main(String[] args) throws IOException {
        ContactsManager.loadFromFile(FILE_NAME);
        Menu.createMenu(new View(), new Add(), new SearchName(), new SearchNumber(), new Delete(), new Exit());

        do {
            int option = Menu.getInput();
            Menu.runOption(option);
        } while (true);
    }
}
