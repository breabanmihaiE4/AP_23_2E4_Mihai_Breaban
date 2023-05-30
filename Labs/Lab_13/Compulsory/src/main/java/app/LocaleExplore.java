package app;

import command.DisplayLocales;
import command.Info;
import command.SetLocale;

import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DisplayLocales displayLocales = new DisplayLocales();
        SetLocale setLocale = new SetLocale();
        Info info = new Info();

        while (true) {
            System.out.println("Enter a command:");
            String command = scanner.nextLine();

            if (command.equals("locales")) {
                displayLocales.execute();
            } else if (command.startsWith("set ")) {
                String localeTag = command.substring(4);
                setLocale.execute(localeTag);
            } else if (command.startsWith("info ")) {
                String localeTag = command.substring(5);
                info.execute(localeTag);
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Unknown command");
            }
        }

        scanner.close();
    }
}
