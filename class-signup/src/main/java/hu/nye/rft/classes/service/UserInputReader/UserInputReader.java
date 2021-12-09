package hu.nye.rft.classes.service.UserInputReader;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInputReader {

    private final BufferedReader reader;

    public UserInputReader(BufferedReader reader) {
        this.reader = reader;
    }

    public String readInput(){
        String input = null;

        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.err.println("Cant read input!");
        }
        return input;
    }
}
