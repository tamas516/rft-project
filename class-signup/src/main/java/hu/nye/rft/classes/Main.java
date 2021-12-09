package hu.nye.rft.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import hu.nye.rft.classes.service.Login;
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
        Login login=new Login(userInputReader);
        String[] ds= login.isTeacher();

        for(String s:ds)
        {
            System.out.println(s);
        }
    }

}
