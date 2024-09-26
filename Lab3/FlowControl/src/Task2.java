public class Task2 {

    public static void main(String[] args) {
        printResults(0, 0);
        printResults(0, 1);
        printResults(1, 0);
        printResults(1, 1);
        printResults(2, 1);
        printResults(1, 2);
        printResults(2, -10);
        printResults(20, 20);
        printResults(21, 21);
        printResults(1, 10);
        printResults(-1, 10);
        printResults(0, Double.MAX_VALUE);
        printResults(1, Double.MAX_VALUE);
        printResults(1, Double.NaN);
    }

    public static double bxx(double t, double l) {
        double sum = 0;
        for (int i = 1; i <= l; i++) {
            if (l % 2 == 1) {
                sum += Math.sqrt(t* i);
            } else {
                sum += (l / Math.sqrt(t));
            }
        }
        return sum;
    }

    static void printResults(double t, double l) {
        System.out.print("t: " + t + " l: " + l + " ");
        System.out.println("Result: " + bxx(t, l));
    }
}
