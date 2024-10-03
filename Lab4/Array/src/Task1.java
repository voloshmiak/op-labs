public class Task1 {
    public static void main(String[] args) {
        printResults(new int[] {-65,-21,-32});
        printResults(new int[] {2,78,63});
        printResults(new int[] {-121,-59,39});
        printResults(new int[] {});
        printResults(null);
    }

    public static int findMaxAbsValue(int[] array) {
        if (array == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxAbsValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) > Math.abs(maxAbsValue)) {
                maxAbsValue = array[i];
            }
        }

        return maxAbsValue;
    }

    static void printResults(int[] array) {
        System.out.println("Array: " + java.util.Arrays.toString(array));
        try { // Відстежуємо помилку
            System.out.println("Result: " + findMaxAbsValue(array));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}