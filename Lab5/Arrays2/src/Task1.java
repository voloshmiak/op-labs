import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        printResults(null);
        printResults(new int[][] {
                {1, 2, 0},
                {2, 1, 0},
                {0, 2, 1}
        });
        printResults(new int[][] {
                {0, 2, 0},
                {1, 0, 0}
        });
        printResults(new int[][] {
                {0, 2, 1, 2},
                {2, 0, 2, 1},
                {1, 2, 0, 1},
                {1, 1, 1, 0}
        });
        printResults(new int[][] {
                {0, 2, 3},
                {2, 0, 3},
                {3, 2, 0}
        });
    }

    public static int getNumberOfWinners(int[][] array) {

        if (array == null) {
            throw new NullPointerException("Matrix is null");
        }

        if (array.length != array[0].length) {
            throw new IllegalArgumentException("Matrix isn't square");
        }

        int numberOfTeams = array.length;

        for (int i = 0; i < numberOfTeams; i++) {
            for (int j = 0; j < numberOfTeams; j++) {
                if (i == j && array[i][j] != 0) {
                    throw new IllegalArgumentException("Matrix main diagonal contains invalid values");
                }
            }
        }

        for (int i = 0; i < numberOfTeams; i++) {
            for (int j = 0; j < numberOfTeams; j++) {
                if (i != j) {
                    if (array[i][j] != 0 && array[i][j] != 1 && array[i][j] != 2) {
                        throw new IllegalArgumentException("Matrix contains invalid values");
                    }
                }
            }
        }

        int[][] formattedArray = new int[3][numberOfTeams];

        for (int i = 0; i < numberOfTeams; i++) {
            formattedArray[0][i] = i+1;
        }

        for (int i = 0; i < numberOfTeams; i++) {
            for (int j = 0; j < numberOfTeams; j++) {
                if (i != j) {
                    if (array[j][i] == 2) {
                        formattedArray[1][i]++;
                    } else if (array[j][i] == 0) {
                        formattedArray[2][i]++;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < numberOfTeams; i++) {
            if (formattedArray[1][i] > formattedArray[2][i]) {
                count++;
            }
        }

        return count;
    }
    static void printResults(int[][] array) {
        try {
            System.out.println("Matrix: ");
            for (int[] row : array) {
                System.out.println(Arrays.toString(row));
            }
        } catch (NullPointerException e) {
            System.out.println("null");
        }

        try {
            System.out.println("Number of winners: " + getNumberOfWinners(array));
        } catch (Exception e) {

            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}