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

public class SubjectUploadTest {

    private final String INPUT = "JAVA";

    private UserInputReader userInputReader;
    private RegDatas regDatas;
    private Connection connection;

    private SubjectUpload underTest;

    @BeforeEach
    public void setUp() {

        connection = Mockito.mock(Connection.class);
        userInputReader = Mockito.mock(UserInputReader.class);
        regDatas = Mockito.mock(RegDatas.class);

        underTest = new SubjectUpload(userInputReader, regDatas);
    }

    @Test
    public void testsubUploadShouldUploadSubjectWhenThereIsNoException() throws SQLException {

        //given
        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(userInputReader.readInput()).thenReturn(INPUT);
        Mockito.when(connection.prepareStatement(SubjectUpload.UPLOAD)).thenReturn(preparedStatement);

        String isteach = "TRUE";

        Mockito.when(regDatas.getIsteacher()).thenReturn(isteach);

        String subject = INPUT;
        String regid = "2";

        Mockito.when(regDatas.getRegid()).thenReturn(regid);


        //when
        underTest.subUpload();

        //then
//        Mockito.verify(userInputReader).readInput();
//        Mockito.verify(connection).prepareStatement(SubjectUpload.UPLOAD);
//        Mockito.verify(preparedStatement).setString(1, subject);
//        Mockito.verify(preparedStatement).setString(2, regid);
//        Mockito.verify(preparedStatement).executeUpdate();
    }

}
