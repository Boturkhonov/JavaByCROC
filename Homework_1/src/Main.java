/**
 * <h2> Homework #1 FizzBuzz </h2>
 * @version 1.0
 * @author Kamron Boturkhonov
 */
public class Main {

    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {

            String res = (i % 3 == 0) ? "Fizz" : "";
            res += (i % 5 == 0) ? "Buzz" : "";
            res = (res.isEmpty()) ? String.valueOf(i) : res;

            System.out.println(res);
        }

    }
}
