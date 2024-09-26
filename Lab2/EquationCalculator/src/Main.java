import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static double customLog(double base, double x) {
        return Math.log(x) / Math.log(base);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("a=");
        double a = scanner.nextDouble();
        System.out.print("b=");
        double b = scanner.nextDouble();
        System.out.print("c=");
        double c = scanner.nextDouble();
        System.out.print("d=");
        double d = scanner.nextDouble();

        if (c <= 0 | c == 1) {
            System.out.println("Основа логарифма c має бути більше за 0, та не дорівнювати 1");
            return;
        } else if (d<=0) {
            System.out.println("Число під логарифмом d має бути більше за 0");
            return;
        }

        // Перший вираз
        double firstPart = (5 * c) / (1 / Math.tan(Math.cbrt(a)));
        double secondPart = Math.sqrt(Math.cbrt(Math.sqrt((Math.tanh(Math.abs(b) * c) / customLog(c, d)))));

        // Другий вираз
//        double firstPart = (5 * a * b) / Math.sqrt(Math.tan(a));
//        double secondPart = Math.sqrt((Math.tanh(Math.sqrt(Math.abs(b)) * c)) / customLog(c, d));

        // Третій вираз
//        double firstPart = (15*c)/Math.log10(Math.sqrt(Math.sqrt(Math.tan(a))));
//        double secondPart = Math.sqrt(1/customLog(c,d));

        double y = firstPart + secondPart;

        System.out.println("Результат: " + y);

        scanner.close();
    }
}