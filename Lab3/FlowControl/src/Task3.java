public class Task3 {

    public static void main(String[] args) {
        printResults(0.01); // Очікується коректний результат
        printResults(0); // Очікується виключення IllegalArgumentException
        printResults(-0.1); // Очікується виключення IllegalArgumentException
        printResults(0.000001); // Очікується коректний результат
        printResults(Double.MAX_VALUE);  // Очікується 1
        printResults(Double.NaN); // Очікується 1
    }

    public static double cxx(double epsilon) {
        if (epsilon <= 0) { // Перевірка умови epsilon
            throw new IllegalArgumentException("Param epsilon = " + epsilon + ", epsilon>0"); // Видаємо помилку
        }
        double sum = 0;
        double term;
        int i = 1;
        do {
            term = 1.0 / (i * i);
            sum += term;
            i++;
        } while (Math.abs(term) >= epsilon); // Виконуємо поки діє умова
        return sum;
    }

    static void printResults(double epsilon) {
        System.out.println("Epsilon: " + epsilon + " ");
        try { // Відстежуємо помилку
            System.out.println("Result: " + cxx(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
