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
        FileManager fm = new FileManager();
        workouts = fm.loadWorkout(); //load existing workouts

        menuLoop:
        //loops the menu after first workout
        while (true) {
            System.out.println("1. Start A Workout\n2. View Previous Workouts\n3. Exit");
            System.out.print("\n> ");
            String input = scanner.nextLine();
            //switch statement to get rid of repeated if statements
            switch (input) {
                case "1":
                    logWorkout();
                    break;
                case "2":
                    if (workouts.isEmpty()) {
                        System.out.println("No workouts to display!");
                    } else {
                        for (Workout workout : workouts) {
                            System.out.println(workout);
                            workout.printExercises();
                        }
                    }
                    break;
                case "3":
                    if (this.workouts.isEmpty()) {
                        System.out.println("You lazy bum!");

                    }
                    printSummary();
                    break menuLoop;
                default:
                    System.out.println("Invalid choice, try again.");
            }
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
            if (exerciseName.equals("stop")) break;

            Exercise exercise = new Exercise(exerciseName);

            System.out.println("Number of sets: ");
            int sets = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= sets; i++) {
                System.out.print("Weight for set " + i + ": ");
                double weight = Double.parseDouble(scanner.nextLine());

                System.out.print("Number of reps for set " + i + ": ");
                int reps = Integer.parseInt(scanner.nextLine());

                exercise.addSet(weight, reps);
            }

            workout.addExercise(exercise);
            exerciseNum++;
        }
        workouts.add(workout);

        FileManager fm = new FileManager();
        fm.saveWorkout(workout); //saves workout to file
    }

    public void printSummary() {
        if (this.workout != null && !this.workout.getExercises().isEmpty()) {
            System.out.println("\nWorkout Summary: \n-------------------------");

            for (Workout workout : workouts) {
                System.out.println(workout + "\n-------------------------");
                for (Exercise exercise : workout.getExercises()) {
                    System.out.println(exercise);
                }
            }

            //for calculating total volume
            double totalVolume = 0;
            for (Workout workout : workouts) {
                for (Exercise exercise : workout.getExercises()) {
                    totalVolume += exercise.getVolume();
                }
            }
            System.out.println("Total volume lifted: " + totalVolume + " lbs");
        }
    }
}