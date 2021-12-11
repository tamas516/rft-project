package hu.nye.rft.classes.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.rft.classes.model.RegDatas;
import hu.nye.rft.classes.service.userinputreader.UserInputReader;

/**
 * My <b>class</b>.
 *
 */

public class Login extends DbConnect {

    static final String LOGIN = "SELECT * FROM REGISTRATION WHERE NAME=? AND PASSWORD=?;";

    private final UserInputReader userInputReader;
    private final RegDatas regDatas;

    public Login(UserInputReader userInputReader, RegDatas regDatas) {
        this.userInputReader = userInputReader;
        this.regDatas = regDatas;
    }

    /**
     * My <b>class</b>.
     *
     */

    public void logmethod() throws SQLException {

        PreparedStatement preparedStatement = con.prepareStatement(LOGIN);
        String name = userInputReader.readInput();
        String pass = userInputReader.readInput();
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pass);
        ResultSet resultSet = preparedStatement.executeQuery();

        String nameDb = "";
        String passDb = "";
        String regiddb = "";
        String isTeachDb = "";

        while (resultSet.next()) {
            nameDb = resultSet.getString(2);
            passDb = resultSet.getString(3);
            regiddb = resultSet.getString(1);
            isTeachDb = resultSet.getString(4);
        }

        if (nameDb.equals(name) && passDb.equals(pass)) {
            regDatas.setIsteacher(isTeachDb);
            regDatas.setRegid(regiddb);
        } else {
            throw new SQLException();
        }

    }
}
