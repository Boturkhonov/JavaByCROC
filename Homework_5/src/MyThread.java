public class MyThread implements Runnable {

    // These two objects are used in synchronized blocks
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    // The index of char in string
    public static int index = -1;
    // The quantity of matches
    public static int numberOfMatches = 0;

    // A given text to search in
    private final String INPUT_STRING;
    // A string to count
    private final String TEMPLATE;


    public MyThread(String input_string, String template) {
        INPUT_STRING = input_string;
        TEMPLATE = template;
    }

    @Override
    public void run() {
        while (index < INPUT_STRING.length() - 1) {

            // Used to memorize the index in one thread until it reaches the end of the loop
            int curIndex = 0;

            synchronized (lock1) {
                if (index < INPUT_STRING.length() - 1) {
                    index++;
                    curIndex = index; // This index is memorized, so that all threads have their own index
                } else {
                    return; // If we reached the end of string we can exit the loop
                }
            }

            boolean f = Matcher.match(String.valueOf(INPUT_STRING.charAt(curIndex)), TEMPLATE);

            synchronized (lock2) {
                if (f) {
                    numberOfMatches++; // If the TEMPLATE is found in the curIndex position the number of matches is increased
                }
                // Uncomment when debugging
                //System.out.println("Thread " + Thread.currentThread().getId() + " char index "+ curIndex + " spaces " + numberOfMatches);
            }

        }

    }

}
