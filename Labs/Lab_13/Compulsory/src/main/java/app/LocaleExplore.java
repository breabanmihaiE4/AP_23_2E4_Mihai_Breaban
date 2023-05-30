package app;

import command.DisplayLocales;
import command.Info;
import command.SetLocale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(Messages.getString("prompt"));
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("display")) {
                DisplayLocales.display();
            } else if (command.toLowerCase().startsWith("set")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    String languageTag = parts[1];
                    SetLocale.set(languageTag);
                } else {
                    System.out.println(Messages.getString("invalid"));
                }
            } else if (command.toLowerCase().startsWith("info")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    String languageTag = parts[1];
                    Info.display(languageTag);
                } else {
                    System.out.println(Messages.getString("invalid"));
                }
            } else {
                System.out.println(Messages.getString("invalid"));
            }
        }
    }
}
