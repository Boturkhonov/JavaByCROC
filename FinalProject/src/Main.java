import controller.Controller;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new MainFrame());
        controller.execute();
    }
}
