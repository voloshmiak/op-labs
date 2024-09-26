public class Task2 {

    public static void main(String[] args) {
        printResults(4, 5); // Очікується коректний результат (l непарне)
        printResults(4, 6); // Очікується коректний результат (l парне)
        printResults(-1, 5); // Очікується Nan через sqrt(t)
        printResults(4, 0); // Очікується результат 0
        printResults(2, 100000); // Очікується коректний результат
        printResults(Double.NaN, 3); // Очікується NaN
    }

    public static double bxx(double t, double l) {
        double sum = 0;
        for (int i = 1; i <= l; i++) { // Сума значень від i=1 до l
            if (l % 2 == 1) { // Перевірка на парність
                sum += Math.sqrt(t* i);
            } else {
                sum += (l / Math.sqrt(t));
            }
        }
        return sum;
    }

    static void printResults(double t, double l) {
        System.out.println("t: " + t + " l: " + l + " ");
        System.out.println("Result: " + bxx(t, l));
    }
}
