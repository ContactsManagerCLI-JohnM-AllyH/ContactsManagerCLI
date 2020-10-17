package contacts;

import menu.*;

public class ContactsApplication {



    public static void main(String[] args) {
        Menu.createMenu(new View(), new Add(), new Search(), new Delete(), new Exit());

        Menu.printOptions();

    }

}
