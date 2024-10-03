import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        printResults(new int[] {-65,-21,-32,54});
        printResults(new int[] {2,78,63,-523});
        printResults(new int[] {-121,-59,39});
        printResults(new int[] {});
        printResults(null);
    }

    public static int[] reverseArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int[] reversedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }

        return reversedArray;
    }

    static void printResults(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
        try { // Відстежуємо помилку
            System.out.println("Result: " + Arrays.toString(reverseArray(array)));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}