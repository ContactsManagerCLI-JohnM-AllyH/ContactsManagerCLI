package menu;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private static final ArrayList<MenuItem> menu = new ArrayList<>();

    public static void createMenu(MenuItem ...items) {
        menu.addAll(Arrays.asList(items));
    }

    public static void printOptions() {
        for (byte i = 0; i < menu.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, menu.get(i).getDescription());
        }
    }

}
