package hu.nye.rft.classes.service;

import java.sql.*;

import hu.nye.rft.classes.model.RegDatas;
import hu.nye.rft.classes.service.userinputreader.UserInputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LoginTest {

    private final String INPUT = "Joe";
    private final String INPUT2 = "asd";


    private UserInputReader userInputReader;
    private RegDatas regDatas;
    private Connection connection;
    private Login login;

    private Login underTest;


    @BeforeEach
    public void setUp() {

        connection = Mockito.mock(Connection.class);
        userInputReader = Mockito.mock(UserInputReader.class);
        regDatas = Mockito.mock(RegDatas.class);

        login = Mockito.mock(Login.class);

        underTest = new Login(userInputReader, regDatas);
    }

    @Test
    public void testLoginmethodShouldSetRegDatasWhenThereIsNoException() throws SQLException {

        //given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(userInputReader.readInput()).thenReturn(INPUT, INPUT2);
        Mockito.when(connection.prepareStatement(Login.LOGIN)).thenReturn(preparedStatement);

        Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);

        String regid = "2";
        String isteach = "TRUE";

        Mockito.when(resultSet.getString(1)).thenReturn(regid);
        Mockito.when(resultSet.getString(4)).thenReturn(isteach);

        //when
        underTest.logmethod();

        //then
        Mockito.verify(regDatas).setRegid(regid);
        Mockito.verify(regDatas).setIsteacher(isteach);
    }


}
