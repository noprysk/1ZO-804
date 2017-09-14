package nao.ocpse7;

import nao.ocpse7.c09.database.DatabaseExample;
import nao.ocpse7.c12.localization.Formatting;

import java.util.Locale;

public class MainApp {

    public static void main(String[] args) {
        DatabaseExample.connectToDB();
    }
}
