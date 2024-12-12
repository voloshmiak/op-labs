import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        printResults("src/file.txt", "src/encrypted.txt", (byte) 1);
    }
    public static boolean cypher(String source, String destination, byte key) {
        if (source == null) {
            throw new NullPointerException("Source is null");
        }
        if (destination == null) {
            throw new NullPointerException("Destination is null");
        }
        if (source.isEmpty()) {
            throw new IllegalArgumentException("Source is empty");
        }
        if (destination.isEmpty()) {
            throw new IllegalArgumentException("Destination is empty");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            String line;
            while ((line = reader.readLine()) != null) {
                byte[] bytes = line.getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ key);
                }
                writer.write(new String(bytes));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Can't read the file");
        }
        return true;
    }
    static void printResults(String s, String d, byte k) {
        try {
            System.out.println(cypher(s, d, k));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}