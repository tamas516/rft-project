package hu.nye.rft.classes.service.userinputreader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * My <b>class</b>.
 *
 */

public class UserInputReader {

    private final BufferedReader reader;

    public UserInputReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * My <b>class</b>.
     *
     */

    public String readInput() {
        String input = null;

        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.err.println("Cant read input!");
        }
        return input;
    }
}
