import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Program for counting number of words in a given file.<br>
 * The file path must be written as a first argument in command prompt.
 * Throws IllegalArgumentException if the path is not given.
 *
 * @author Kamron Boturkhonov
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("File path is missing!");
        }
        String path = args[0];

        try (Reader r = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)) {
            StringBuilder text = new StringBuilder();
            int c;
            while ((c = r.read()) != -1) {
                text.append((char)c);
            }

            System.out.println("\nFile content: ");
            System.out.println(text);
            System.out.println("\nNumber of words: " + getNumberOfWords(text.toString()));
        } catch (FileNotFoundException e) {
            System.out.println("Can't open the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Counts the number of words in given text
     * @param text a text to find words in
     * @return Number of words in {@code text}
     */
    private static long getNumberOfWords(String text) {
        String regex = "\\w+";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}