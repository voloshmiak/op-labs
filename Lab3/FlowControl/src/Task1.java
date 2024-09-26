public class Task1 {

    public static void main(String[] args) {
        printResults(3, -1, 1); // Очікується коректний результат
        printResults(1, -1, 1); // Очікується виключення IllegalArgumentException
        printResults(21, -1, 1); // Очікується виключення IllegalArgumentException
        printResults(5, 1, 1); // Очікується NaN через Math.log(-t * i)
        printResults(5, -1, Double.MAX_VALUE); // Очікується коректний результат
        printResults(5, -1, 0.000001); // Очікується коректний результат
        printResults(3, Double.NaN, 0); // Очікується NaN
    }

    public static double axx(double k, double t, double s) {
        if (k < 2 || k > 20) { // Перевірка умови k
            throw new IllegalArgumentException("param k = " + k + ", 2<k<20"); // Видаємо помилку
        }
        double sum = 0.0;
        for (double i = 1; i <= k; i++) { // Сума значень від i=1 до k
            double term = Math.log(-t * i) * Math.cos(Math.sqrt(s / (i * i)));
            sum += term;
        }
        return sum;
    }

    static void printResults(double k, double t, double s) {
        System.out.println("k: " + k + ", t: " + t + ", s: " + s);
        try { // Відстежуємо помилку
            System.out.println("Result: " + axx(k, t, s));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
