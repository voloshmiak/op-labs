import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        printResults("src/file.txt");
        printResults("");
        printResults(null);
        printResults("src/empty.txt");
    }
    public static long numberOfLatinCharacters(String filename) {

        if (filename == null) {
            throw new NullPointerException("Filename is null");
        }

        if (filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is empty");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines()
                    .flatMapToInt(CharSequence::chars)
                    .filter(c -> (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
                    .count();
        } catch (IOException e) {
            throw new FileNotFoundException("Can't read the file");
        }
    }
    static void printResults(String s) {
        try {
            System.out.println(numberOfLatinCharacters(s));
        } catch (IllegalArgumentException | NullPointerException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}