import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        printResults(new short[] {1, 2, 3, 4, 5});
        printResults(new short[] {5, 4, 3, 2, 1});
        printResults(new short[] {1, 2, 3, 2, 1});
        printResults(null);
        printResults(new short[] {});
    }

    public static short[] bubbleSort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        boolean swappedSomething = true;
        while (swappedSomething) {
            swappedSomething = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i+1]) {
                    swappedSomething = true;
                    short temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

    static void printResults(short[] array) {
        try {
            System.out.println(Arrays.toString(bubbleSort(array)));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}