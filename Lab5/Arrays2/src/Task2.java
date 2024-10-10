import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        printResults(new int[][] {
                {1, 2, 3}
        },
        new int[][] {
                {1},
                {2},
                {3}
        });
        printResults(new int[][] {},
        new int[][] {
                {1},
                {2},
                {3}
        });
        printResults(new int[][] {
                {1,2},
                {3,4},
                {5,6}
                },
        new int[][] {
                {},
                {2,4},
                {3,6}
        });
        printResults(null, null);
        printResults(new int[][] {
                {1, 2}
        },
        new int[][] {
                {1,2},
                {2,4},
                {3,6}
        });
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        if (a == null || b == null) {
            throw new NullPointerException("a or b is null");
        }

        int aRows = a.length;
        int bRows = b.length;

        if (aRows == 0 || bRows == 0) {
            throw new IllegalArgumentException("a or b cannot be empty");
        }

        int aCols = a[0].length;
        int bCols = b[0].length;

        if (aCols == 0 || bCols == 0) {
            throw new IllegalArgumentException("a or b cannot have empty rows");
        }
        if (aCols != bRows) {
            throw new IllegalArgumentException("aCols != bRows");
        }

        int[][] result = new int[aRows][bCols];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                for (int k = 0; k < aCols; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    static void printResults(int[][] a, int[][] b) {
        try {
            System.out.println("Matrix A: ");
            for (int[] row : a) {
                System.out.println(Arrays.toString(row));
            }
        } catch (NullPointerException e) {
            System.out.println("null");
        }

        try {
            System.out.println("Matrix B: ");
            for (int[] row : b) {
                System.out.println(Arrays.toString(row));
            }
        } catch (NullPointerException e) {
            System.out.println("null");
        }

        try {
            System.out.println("Result: ");
            int[][] result = multiply(a, b);
            for (int[] row : result) {
                System.out.println(Arrays.toString(row));
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
