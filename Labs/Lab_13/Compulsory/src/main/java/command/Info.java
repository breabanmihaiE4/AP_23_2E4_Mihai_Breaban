package command;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    public static void display(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);

        System.out.println(Messages.getString("info") + " " + locale);

        // Display country and language
        String country = locale.getDisplayCountry(locale);
        String language = locale.getDisplayLanguage(locale);
        System.out.println("Country: " + country + " (" + language + ")");

        // Display currency
        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency: " + currency.getDisplayName(locale) + " (" + currency.getCurrencyCode() + ")");

        // Display week days
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String[] weekDays = dateFormatSymbols.getWeekdays();
        System.out.print("Week Days: ");
        for (int i = 2; i < weekDays.length; i++) {
            System.out.print(weekDays[i] + ", ");
        }
        System.out.println();

        // Display months
        String[] months = dateFormatSymbols.getMonths();
        System.out.print("Months: ");
        for (String month : months) {
            System.out.print(month + ", ");
        }
        System.out.println();

        // Display current date
        Date currentDate = new Date();
        String formattedDate = DateFormat.getDateInstance(DateFormat.LONG, locale).format(currentDate);
        System.out.println("Today: " + formattedDate);
    }
}
