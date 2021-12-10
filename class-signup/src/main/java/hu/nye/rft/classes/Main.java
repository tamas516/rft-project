package hu.nye.rft.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import hu.nye.rft.classes.model.RegDatas;
import hu.nye.rft.classes.service.Login;
import hu.nye.rft.classes.service.SubjectApplication;
import hu.nye.rft.classes.service.SubjectUpload;
import hu.nye.rft.classes.service.UserInputReader.UserInputReader;

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

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        UserInputReader userInputReader=new UserInputReader(bufferedReader);
        System.out.println("Need a username and a password! ");
        RegDatas regDatas=new RegDatas(null,null);
        Login login=new Login(userInputReader, regDatas);
        login.LoginMethod();
        SubjectUpload subjectUpload=new SubjectUpload(userInputReader, regDatas);

        if(regDatas.getIs_teacher().equals("TRUE")) {
            subjectUpload.subUpload();
        }


        SubjectApplication subjectApplication=new SubjectApplication(userInputReader, regDatas);

        if(regDatas.getIs_teacher().equals("FALSE")) {
            subjectApplication.apply();
        }



    }

}
