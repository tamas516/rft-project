package hu.nye.rft.classes;

import java.sql.*;

/**
 * My <b>class</b>.
 *
 */

public class Main {

    /**
     * My <b>class</b>.
     *
     */
    public static void main(String[] args) throws SQLException {

        Connection connection= DriverManager.getConnection("jdbc:h2:tcp://localhost/./rft-class","sa","123");

        String query="INSERT INTO REGISTRATION (NAME, PASSWORD, IS_TEACHER) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "Joe");
        preparedStatement.setString(2, "asd");
        preparedStatement.setString(3, "1");
        preparedStatement.executeUpdate();
    }

}
