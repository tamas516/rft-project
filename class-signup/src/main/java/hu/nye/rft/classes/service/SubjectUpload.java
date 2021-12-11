package hu.nye.rft.classes.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.nye.rft.classes.model.RegDatas;
import hu.nye.rft.classes.service.userinputreader.UserInputReader;

/**
 * My <b>class</b>.
 *
 */

public class SubjectUpload extends DbConnect {

    static final String UPLOAD = "INSERT INTO SUBJECT (NAME,REG_ID) VALUES (?,?);";

    private final UserInputReader userInputReader;
    private final RegDatas regDatas;

    public SubjectUpload(UserInputReader userInputReader, RegDatas regDatas) {
        this.userInputReader = userInputReader;
        this.regDatas = regDatas;
    }

    /**
     * My <b>class</b>.
     *
     */

    public void subUpload() throws SQLException {

        String isTeach = regDatas.getIsteacher();
        String regid = regDatas.getRegid();

        if (isTeach.equals("TRUE")) {
            System.out.println("Need a subject name! ");
            PreparedStatement preparedStatement = con.prepareStatement(UPLOAD);
            preparedStatement.setString(1, userInputReader.readInput());
            preparedStatement.setString(2, regid);
            preparedStatement.executeUpdate();
            System.out.println("Upload is successful! ");
        } else {
            System.out.println("User is not teacher! ");
        }



    }
}
