public class Task3 {

    public static void main(String[] args) {
        printResults(0);
        printResults(2);
        printResults(1);
        printResults(-10);
        printResults(6);
        printResults(7);
        printResults(12);
        printResults(78);
        printResults(0);
        printResults(Double.MAX_VALUE);
        printResults(Double.NaN);
    }

    public static double cxx(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("param e = " + epsilon + ", e>0");
        }
        double sum = 0;
        double term;
        int i = 1;
        do {
            term = 1.0 / (i * i);
            i++;
        } while (Math.abs(term)>=epsilon);
        return sum;
    }

    static void printResults(double epsilon) {
        System.out.print("e: " + epsilon + " ");
        try {
            System.out.println("Result: " + cxx(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
