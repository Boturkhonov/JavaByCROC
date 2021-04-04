import java.util.*;

/**
 * @author Kamron
 */
public class Main {

    static String PATH = "КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики";

    // Current directory sign
    static final String CURRENT_DIR = ".";
    // Previous directory sign
    static final String PREVIOUS_DIR = "..";
    // Directory separator sign
    static final String SEPARATOR = "/";

    public static void main(String[] args) {

        System.out.println(getNormalizedPath(PATH));

    }

    private static String getNormalizedPath(String path) {

        String[] splatPath = path.split(SEPARATOR);

        Deque<String> normalizedPath = new LinkedList<>();

        for (String s : splatPath) {
            switch (s) {
                case CURRENT_DIR:
                    break;
                case PREVIOUS_DIR:
                    String lastDir = normalizedPath.peekLast();
                    if (lastDir == null) {
                        // When there is no directory left to remove
                        normalizedPath.offerLast(PREVIOUS_DIR);
                    } else if (lastDir.equals(PREVIOUS_DIR)) {
                        // When there are only "previous directory sign"s
                        normalizedPath.offerLast(PREVIOUS_DIR);
                    } else {
                        // If there is directory name to remove
                        normalizedPath.removeLast();
                    }
                    break;
                default:
                    // If the current string is a directory name
                    normalizedPath.offerLast(s);
            }
        }

        // Joining the normalized path
        StringBuilder result = new StringBuilder();
        while (!normalizedPath.isEmpty()) {
            result.append(normalizedPath.pollFirst());
            result.append(SEPARATOR);
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

}
