package hu.nye.rft.classes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.rft.classes.model.RegDatas;
import hu.nye.rft.classes.service.userinputreader.UserInputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SubjectApplicationTest {

    private final String INPUT = "RFT";

    private UserInputReader userInputReader;
    private RegDatas regDatas;
    private Connection connection;

    private SubjectApplication underTest;

    @BeforeEach
    public void setUp() {

        connection = Mockito.mock(Connection.class);
        userInputReader = Mockito.mock(UserInputReader.class);
        regDatas = Mockito.mock(RegDatas.class);

        underTest = new SubjectApplication(userInputReader, regDatas);
    }

    @Test
    public void testChooseSubjectShouldReturnSubIdWhenThereIsNoException() throws SQLException {

        //given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(userInputReader.readInput()).thenReturn(INPUT);
        Mockito.when(connection.prepareStatement(SubjectApplication.APPLICATION)).thenReturn(preparedStatement);

        Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);

        String subid = "1";

        Mockito.when(resultSet.getString(1)).thenReturn(subid);

        //when
        underTest.chooseSubject();

        //then
        //Mockito.verify()

    }

    @Test
    public void testApplyShouldUploadApplicationDatasWhenThereIsNoException() throws SQLException {

        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);

        String subid = "2";
        Mockito.when(underTest.chooseSubject()).thenReturn(subid);

        String regid = "4";
        Mockito.when(regDatas.getRegid()).thenReturn(regid);

        String isteach = "FALSE";
        Mockito.when(regDatas.getIsteacher()).thenReturn(isteach);

        //when

        underTest.apply();

    }

}
