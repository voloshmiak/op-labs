public class Task1 {

    public static void main(String[] args) {
        printResults(0, 0,4);
        printResults(0, 1,6);
        printResults(1, 0,1);
        printResults(1, 1,6);
        printResults(2, 1,8);
        printResults(1, 2,0);
        printResults(2, -10,3);
        printResults(20, 20,6);
        printResults(21, 21,7);
        printResults(1, 10,12);
        printResults(-1, 10,78);
        printResults(0, Double.MAX_VALUE,3);
        printResults(1, Double.MAX_VALUE,1);
        printResults(1, Double.NaN, 2);

    }

    public static double axx(double k, double t, double s) {
        if (k < 2 || k > 20) {
            throw new IllegalArgumentException("param k = " + k + ", 2<k<20");
        }
        double sum = 0.0;
        for (double i = 1; i <= k; i++) {
            double term = Math.log(-t * i) * Math.cos(Math.sqrt(s / (i * i)));
            sum += term;
        }
        return sum;
    }

    static void printResults(double k, double t, double s) {
        System.out.print("k: " + k + ", t: " + t + ", s: " + s);
        try {
            System.out.println("Result: " + axx(k, t, s));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
