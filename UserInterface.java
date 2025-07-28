import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Exercise> exercises;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.exercises = new ArrayList<>();
    }

    public void start() {
        System.out.println("Welcome back! Ready to start a workout?");
        System.out.print("Type yes/no: ");

        while (true) {
            String readyOrNot = scanner.nextLine();
            if (readyOrNot.equals("yes")) {
                System.out.println("First Exercise: ");
                String exerciseName = scanner.nextLine();
            } else if (readyOrNot.equals("no")){
                System.out.println("You lazy bum!");
                break;
            }
        }
    }
}