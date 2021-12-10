package hu.nye.rft.classes.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.rft.classes.model.RegDatas;
import hu.nye.rft.classes.service.UserInputReader.UserInputReader;

public class SubjectApplication extends DbConnect{

    static final String CHOOSE = "SELECT * FROM SUBJECT WHERE NAME=?;";
    static final String APPLICATION = "INSERT INTO SIGNUP (REG_ID,SUB_ID) VALUES (?,?);";

    private final UserInputReader userInputReader;
    private final RegDatas regDatas;

    public SubjectApplication(UserInputReader userInputReader, RegDatas regDatas) {
        this.userInputReader = userInputReader;
        this.regDatas = regDatas;
    }

    public String chooseSubject() throws SQLException {

        String subName= userInputReader.readInput();

        PreparedStatement preparedStatement= con.prepareStatement(CHOOSE);
        preparedStatement.setString(1,subName);
        ResultSet resultSet = preparedStatement.executeQuery();

        String subIdDb="";

        while (resultSet.next()) {
            subIdDb = resultSet.getString(1);
        }

        return subIdDb;
    }

    public void apply() throws SQLException {

        System.out.println("Choose a subject!");
        String sub_id=chooseSubject();

        String isTeach=regDatas.getIs_teacher();
        String reg_id=regDatas.getReg_id();

        if(isTeach.equals("FALSE")) {
        PreparedStatement preparedStatement= con.prepareStatement(APPLICATION);
        preparedStatement.setString(1,reg_id);
        preparedStatement.setString(2,sub_id);
            preparedStatement.executeUpdate();
            System.out.println("Application is successful! ");
        }
        else {
            System.out.println("User is not a student! ");
        }
    }
}
