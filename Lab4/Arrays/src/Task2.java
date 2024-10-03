import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        printResults(new int[] {-65,-21,-32,54});
        printResults(new int[] {2,78,63,3});
        printResults(new int[] {-121,-59,39,-87});
        printResults(new int[] {});
        printResults(null);
    }

    public static double findAvarage(int[] array) {
        if (array == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        double sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 3 == 0) {
                sum += array[i];
                count++;
            }
        }

        return sum / count;
    }

    static void printResults(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
        try { // Відстежуємо помилку
            System.out.println("Result: " + findAvarage(array));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}