package hu.nye.rft.classes.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * My <b>class</b>.
 *
 */

public class DbConnect {

    Connection con;

    public DbConnect() {
        try {
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/./rft-class", "sa", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
