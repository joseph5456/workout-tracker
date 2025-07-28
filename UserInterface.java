import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Welcome back! Ready to start a workout?");
            System.out.print("Type yes/no: ");
            String readyOrNot = scanner.nextLine();
            if (readyOrNot.equals("yes")) {
                System.out.println("Placeholder");
            } else if (readyOrNot.equals("no")){
                break;
            }
        }
    }
}