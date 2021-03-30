import java.util.ArrayList;
import java.util.List;

/**
 * Стартовый класс.
 */
public class Main {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {

        // Testing the method that uses for loop
        System.out.println("\nResult of counting matches using for loop: ");
        long current = System.currentTimeMillis();

        System.out.println("Count of space: " + countMatchesUsingLoop(INPUT_STRING, TEMPLATE));
        System.out.println("Time: " + (System.currentTimeMillis() - current)/1000.0  + " s.");


        // Testing the method that uses threads
        System.out.println("\nResult of counting matches using Matcher.match");
        current = System.currentTimeMillis();
        try {
            System.out.println("Count of space: " + countMatchesUsingMatcher(INPUT_STRING, TEMPLATE));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time: " + (System.currentTimeMillis() - current)/1000.0  + " s.");
    }


    /**
     * Returns the number of all appearances of {@code template} in {@code inputString} using for loop
     * @param inputString a text to search in
     * @param template a string to find
     * @return The number of matches
     */
    public static int countMatchesUsingLoop(String inputString, String template) {
        int sum = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == template.charAt(0)) sum++;
        }

        return sum;
    }

    /**
     * Returns the number of all appearances of {@code template} in {@code inputString} using
     * {@code Matcher.match} methods
     * @param inputString a text to search in
     * @param template a string to find
     * @return The number of matches
     * @throws InterruptedException if any of threads is interrupted
     */
    public static int countMatchesUsingMatcher(String inputString, String template) throws InterruptedException {

        // List of threads
        List<Thread> threads = new ArrayList<>();

        // The number of threads is equal to the half of input string length
        int numberOfThreads = (int) (inputString.length() * 0.5);

        for (int i = 0; i < numberOfThreads; i++) {
            threads.add(new Thread(new MyThread(inputString, template)));
            threads.get(i).start();
        }

        for (Thread thread: threads) {
            thread.join(); // Used for waiting the thread until it finishes its job
        }

        // After all threads finished their work the result is returned
        return MyThread.numberOfMatches;
    }
}