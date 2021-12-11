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

public class SubjectApplication extends DbConnect {

    static final String CHOOSE = "SELECT * FROM SUBJECT WHERE NAME=?;";
    static final String APPLICATION = "INSERT INTO SIGNUP (REG_ID,SUB_ID) VALUES (?,?);";

    private final UserInputReader userInputReader;
    private final RegDatas regDatas;

    public SubjectApplication(UserInputReader userInputReader, RegDatas regDatas) {
        this.userInputReader = userInputReader;
        this.regDatas = regDatas;
    }

    /**
     * My <b>class</b>.
     *
     */

    public String chooseSubject() throws SQLException {

        String subName = userInputReader.readInput();

        PreparedStatement preparedStatement = con.prepareStatement(CHOOSE);
        preparedStatement.setString(1, subName);
        ResultSet resultSet = preparedStatement.executeQuery();

        String subIdDb = "";

        while (resultSet.next()) {
            subIdDb = resultSet.getString(1);
        }

        return subIdDb;
    }

    /**
     * My <b>class</b>.
     *
     */

    public void apply() throws SQLException {

        System.out.println("Choose a subject!");
        String subid = chooseSubject();

        String isTeach = regDatas.getIsteacher();
        String regid = regDatas.getRegid();

        if (isTeach.equals("FALSE")) {
        PreparedStatement preparedStatement = con.prepareStatement(APPLICATION);
        preparedStatement.setString(1, regid);
        preparedStatement.setString(2, subid);
            preparedStatement.executeUpdate();
            System.out.println("Application is successful! ");
        } else {
            System.out.println("User is not a student! ");
        }
    }
}
