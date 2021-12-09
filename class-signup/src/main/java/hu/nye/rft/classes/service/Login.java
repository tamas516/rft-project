package hu.nye.rft.classes.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.rft.classes.service.UserInputReader.UserInputReader;

public class Login extends DbConnect{

    static final String LOGIN = "SELECT * FROM REGISTRATION WHERE NAME=? AND PASSWORD=?;";

    private final UserInputReader userInputReader;


    public Login(UserInputReader userInputReader) {
        this.userInputReader = userInputReader;
    }

    public String[] isTeacher() throws SQLException {

        PreparedStatement preparedStatement=con.prepareStatement(LOGIN);
        preparedStatement.setString(1, userInputReader.readInput());
        preparedStatement.setString(2, userInputReader.readInput());
        ResultSet resultSet = preparedStatement.executeQuery();

        String user = resultSet.getString(1);
        String pass = resultSet.getString(2);

        String[] log = {user, pass};

        return log;

    }
}
