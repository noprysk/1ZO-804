package nao.ocpse7;

import nao.ocpse7.c12.localization.Formatting;

import java.util.Locale;

public class MainApp {

    public static void main(String[] args) {
        Formatting.formatNumber(Locale.FRANCE, 10_000_000L);
    }
}
