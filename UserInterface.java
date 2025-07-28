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
                System.out.println("Number of sets: ");
                int sets = Integer.valueOf(scanner.nextLine());
                System.out.println("Number of reps: ");
                int reps = Integer.valueOf(scanner.nextLine());

                //create exercise object and add to list
                Exercise exercise1 = new Exercise(exerciseName, sets, reps);
                exercises.add(exercise1);

            } else if (readyOrNot.equals("no")){
                System.out.println("You lazy bum!");
                break;
            }
        }
    }
}