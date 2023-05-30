package command;

import java.util.Locale;

public class SetLocale {
    public static void set(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);

        String message = Messages.getString("locale.set");
        System.out.println(message + " " + locale);
    }
}
