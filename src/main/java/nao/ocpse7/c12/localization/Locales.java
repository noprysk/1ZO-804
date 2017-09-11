package nao.ocpse7.c12.localization;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Locales {

    public static  void testGetAllLocales() {
        List<Locale> locales = Arrays.stream(Locale.getAvailableLocales())
                .filter(item -> item.getLanguage().equalsIgnoreCase("uk"))
                .collect(Collectors.toList());

        //locales.forEach(System.out::println);
        for (Locale locale : locales) {
            System.out.println(locale);
        }
    }

    public static void testResoureceBundel() {
        Locale.setDefault(Locale.ITALY);
        Locale locale = Locale.getDefault();
        System.out.println("Current locale: " + locale);

        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourceBundle", locale);
        System.out.println("Greeting: " + resourceBundle.getString("greeting"));

    }
}
