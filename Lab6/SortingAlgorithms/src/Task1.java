public class Task1 {
    public static void main(String[] args) {
        printResults(new short[] {6, 7, 8, 9, 10});
        printResults(new short[] {10, 9, 8, 7, 6});
        printResults(new short[] {6, 7, 8, 7, 6});
        printResults(null);
        printResults(new short[] {});
    }

    public static short[] insertionSort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        for (int i = 1; i < array.length; i++) {
            short temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    static void printResults(short[] array) {
        try {
            System.out.println(java.util.Arrays.toString(insertionSort(array)));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
