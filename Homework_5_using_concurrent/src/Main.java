import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

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

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000.0 + " s.");


        // Testing the method that uses threads
        System.out.println("\nResult of counting matches using Matcher.match");
        current = System.currentTimeMillis();
        try {
            System.out.println("Count of space: " + countMatchesUsingThreads(INPUT_STRING, TEMPLATE));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000.0 + " s.");

    }


    /**
     * Returns the number of all appearances of {@code template} in {@code inputString} using for loop
     *
     * @param inputString a text to search in
     * @param template    a string to find
     * @return The number of matches
     */
    private static int countMatchesUsingLoop(String inputString, String template) {
        int numberOfMatches = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == template.charAt(0)) numberOfMatches++;
        }

        return numberOfMatches;
    }


    /**
     * Returns the number of all appearances of {@code template} in {@code inputString} using
     * {@code Matcher.match} methods
     *
     * @param inputString a text to search in
     * @param template    a string to find
     * @return The number of matches
     * @throws InterruptedException if any of threads is interrupted
     */
    private static int countMatchesUsingThreads(String inputString, String template) throws InterruptedException {
        AtomicInteger numberOfMatches = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(inputString.length());

        int numberOfThreads = inputString.length() / 2;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < inputString.length(); i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    if (Matcher.match(String.valueOf(inputString.charAt(finalI)), template)) {
                        numberOfMatches.getAndAdd(1);
                    }
                    countDownLatch.countDown();
                }
            });
        }
        executorService.shutdown();
        countDownLatch.await();

        return numberOfMatches.get();
    }
}