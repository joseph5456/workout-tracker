import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Workout> workouts;
    private Workout workout;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.workouts = new ArrayList<>();
    }

    public void start() {
        System.out.println("Welcome back! Ready to start a workout?");
        System.out.print("Type yes/no: ");
        String input = scanner.nextLine();

        if (input.equals("yes")) {
            logWorkout();
            printSummary();
        } else if (input.equals("no")) {
            System.out.println("You lazy bum!");
        }
    }

    public void logWorkout() {
        System.out.println("Workout name: " );
        String workoutName = scanner.nextLine();
        this.workout = new Workout(workoutName);

        int exerciseNum = 1;

        while (true) {
            System.out.println("\nExercise " + exerciseNum + ":");
            String exerciseName = scanner.nextLine();
            if (exerciseName.equals("stop")) {
                break;
            }
            System.out.println("Number of sets: ");
            int sets = Integer.parseInt(scanner.nextLine());

            int maxReps = 0;
            int maxWeight = 0;
            for (int i = 1; i <= sets; i++) {
                System.out.print("Please enter weight for set " + i + ": ");
                int weight = Integer.parseInt(scanner.nextLine());
                if (weight > maxWeight) {
                    maxWeight = weight;
                }

                System.out.print("Please enter number of reps for set " + i + ": ");
                int reps = Integer.parseInt(scanner.nextLine());
                if (reps > maxReps) {
                    maxReps = reps;
                }
            }

            //create exercise object and add to list
            Exercise exercise = new Exercise(exerciseName, sets, maxReps, maxWeight);
            workout.addExercise(exercise);
            exerciseNum++;
        }
    }

    public void printSummary() {
        if (workout != null && !this.workout.getExercises().isEmpty()) {
            System.out.println("\nWorkout Summary: \n-------------------------");
            System.out.println(workout.getWorkoutName() + "\n-------------------------");
            for (Exercise exercise : workout.getExercises()) {
                System.out.println(exercise);
            }

            int totalVolume = 0;
            for (Exercise exercise : workout.getExercises()) {
                totalVolume += exercise.getVolume();
            }
            System.out.println("Total volume lifted: " + totalVolume + " lbs");
        }
    }

}