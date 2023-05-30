package command;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public void execute(String localeTag) {
        Locale locale = new Locale(localeTag);
        Locale.setDefault(locale);
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");
        System.out.println(messages.getString("locale.set") + " " + locale.getDisplayName());
    }
}
