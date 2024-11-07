public class Task1 {
    public static void main(String[] args) {
        printResults(null);
        printResults("777");
    }

    public static int octStringToInt(String s) {
        if (null == s) {
            throw new NullPointerException("Argument is null");
        }
        int result = 0;
        int base = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c < '0' || c > '7') {
                throw new IllegalArgumentException("Argument digits not in [0,7]");
            }
            result += (c - '0') * base;
            base *= 8;
        }

        return result;
    }

    static void printResults(String s) {
        try {
            System.out.println(octStringToInt(s));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}