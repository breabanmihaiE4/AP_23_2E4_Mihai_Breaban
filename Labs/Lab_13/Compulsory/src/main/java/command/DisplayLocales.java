package command;

import java.util.Locale;

public class DisplayLocales {
    public static void display() {
        Locale[] locales = Locale.getAvailableLocales();

        System.out.println(Messages.getString("locales"));

        for (Locale locale : locales) {
            String displayLanguage = locale.getDisplayLanguage(locale);
            System.out.println(displayLanguage);
        }
    }
}
