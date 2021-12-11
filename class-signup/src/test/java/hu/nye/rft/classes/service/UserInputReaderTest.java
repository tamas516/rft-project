package hu.nye.rft.classes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

import java.io.BufferedReader;
import java.io.IOException;

import hu.nye.rft.classes.service.userinputreader.UserInputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserInputReaderTest {

    private final String INPUT = "input";

    @Mock
    private BufferedReader bufferedReader;

    private UserInputReader underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserInputReader(bufferedReader);
    }

    @Test
    public void testReadInputShouldReturnInputReadByBufferedReader() throws IOException {

        //given
        given(bufferedReader.readLine()).willReturn(INPUT);

        //when
        String result = underTest.readInput();

        //then
        assertEquals(INPUT, result);

    }

    @Test
    public void testReadInputShouldReturnNullWhenBufferedReaderThrowsException() throws IOException {

        //given
        doThrow(IOException.class).when(bufferedReader).readLine();

        //when
        String result = underTest.readInput();

        //then
        assertNull(result);

    }
}
