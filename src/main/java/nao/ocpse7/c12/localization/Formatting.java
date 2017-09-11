package nao.ocpse7.c12.localization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Formatting {

    public static void specificLocale(Locale locale, Date date) {

        DateFormat spec = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        System.out.println(spec.format(date));
    }

    public static void formatNumber(Locale locale, long value) {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        System.out.println(format.format(value));

    }

}
