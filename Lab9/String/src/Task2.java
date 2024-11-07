public class Task2 {
    public static void main(String[] args) {
        printResults(null);
        printResults("The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago");
    }

    public static int checkForNums(String s) {
        if (null == s) {
            throw new NullPointerException("Argument is null");
        }
        int count = 0;

        String[] words = s.split(" ");

        for (String word : words) {
            if (word.matches("\\d+")) {
                count++;
            }
        }

        return count;
    }

    static void printResults(String s) {
        try {
            System.out.println(checkForNums(s));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}