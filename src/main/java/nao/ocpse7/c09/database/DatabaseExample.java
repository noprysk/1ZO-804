package nao.ocpse7.c09.database;

import java.sql.*;

public class DatabaseExample {

    public static void connectToDB() {

        Connection connection = null;
        Statement statement = null;
        try {
            connection =
                    DriverManager.getConnection("jdbc:jtds:sqlserver://DFQASQL:1433/HSV32MAIN", "hs", "topgun");

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("Select Top 10 * From hs.HS_USER");
            //result.
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
