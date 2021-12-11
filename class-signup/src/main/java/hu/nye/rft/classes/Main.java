package hu.nye.rft.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

import hu.nye.rft.classes.model.RegDatas;
import hu.nye.rft.classes.service.Login;
import hu.nye.rft.classes.service.SubjectApplication;
import hu.nye.rft.classes.service.SubjectUpload;
import hu.nye.rft.classes.service.userinputreader.UserInputReader;

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
        UserInputReader userInputReader = new UserInputReader(bufferedReader);
        System.out.println("Need a username and a password! ");
        RegDatas regDatas = new RegDatas(null, null);
        Login login = new Login(userInputReader, regDatas);
        login.Loginmethod();
        SubjectUpload subjectUpload = new SubjectUpload(userInputReader, regDatas);

        if (regDatas.getIsteacher().equals("TRUE")) {
            subjectUpload.subUpload();
        }


        SubjectApplication subjectApplication = new SubjectApplication(userInputReader, regDatas);

        if (regDatas.getIsteacher().equals("FALSE")) {
            subjectApplication.apply();
        }



    }

}
