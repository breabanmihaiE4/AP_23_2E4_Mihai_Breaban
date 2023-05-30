package command;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public void execute(String localeTag) {
        Locale locale = new Locale(localeTag);
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");
        ResourceBundle localeMessages = ResourceBundle.getBundle("res.Messages", locale);

        System.out.println(localeMessages.getString("info") + " " + locale.getDisplayName());
        System.out.println("Country: " + locale.getDisplayCountry() + " (" + localeMessages.getString("country") + ")");
        System.out.println("Language: " + locale.getDisplayLanguage() + " (" + localeMessages.getString("language") + ")");
        System.out.println("Currency: " + Currency.getInstance(locale).getCurrencyCode() + " (" + localeMessages.getString("currency") + ")");

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        System.out.println("Week Days: " + String.join(", ", dateFormatSymbols.getWeekdays()));
        System.out.println("Months: " + String.join(", ", dateFormatSymbols.getMonths()));

        SimpleDateFormat dateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG, locale);
        String today = dateFormat.format(new Date());
        System.out.println("Today: " + today + " (" + today + ")");
    }
}
