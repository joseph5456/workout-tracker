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
        System.out.println("Welcome back! Ready to start a workout? \nType yes/no");
        String input = scanner.nextLine();

        if (input.equals("yes")) {
            logWorkout();
            while (true) {
                System.out.println("Would you like to start another workout? \nType yes/no");
                String input2 = scanner.nextLine();
                if (input2.equals("yes")) {
                    logWorkout();
                } else if (input2.equals("no")) {
                    break;
                }
            }
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
            double maxWeight = 0;
            for (int i = 1; i <= sets; i++) {
                System.out.print("Please enter weight for set " + i + ": ");
                double weight = Integer.parseInt(scanner.nextLine());
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
        workouts.add(workout);
    }

    public void printSummary() {
        if (this.workout != null && !this.workout.getExercises().isEmpty()) {
            System.out.println("\nWorkout Summary: \n-------------------------");

            for (Workout workout : workouts) {
                System.out.println(workout + "\n-------------------------");
                for (Exercise exercise : this.workout.getExercises()) {
                    System.out.println(exercise);
                }
            }

            //for calculating total volume
            double totalVolume = 0;
            for (Exercise exercise : workout.getExercises()) {
                totalVolume += exercise.getVolume();
            }
            System.out.println("Total volume lifted: " + totalVolume + " lbs");
        }
    }

}