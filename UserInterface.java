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
        System.out.println("Welcome back!\n1. Start Workout\n2. View Previous Workouts\n3. Exit");
        System.out.print("\n> ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            logWorkout();
            //loops the menu after first workout
            menuLoop:
            while (true) {
                System.out.println("1. Start Another Workout\n2. View Previous Workouts\n3. Exit");
                System.out.print("\n> ");
                String input2 = scanner.nextLine();
                //switch statement to get rid of repeated if statements
                switch (input2) {
                    case "1":
                        logWorkout();
                        break;
                    case "2":
                        for (Workout workout : workouts) {
                            System.out.println(workout);
                            this.workout.printExercises();
                        }
                        break;
                    case "3":
                        break menuLoop;
                }
            }
            printSummary();
        } else if (input.equals("2")){
            if (workouts.isEmpty()) {
                System.out.println("\nNo previous workouts to display!");
            }
        } else if (input.equals("3")) {
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
                System.out.print("Weight for set " + i + ": ");
                double weight = Integer.parseInt(scanner.nextLine());
                if (weight > maxWeight) {
                    maxWeight = weight;
                }

                System.out.print("Number of reps for set " + i + ": ");
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
            for (Workout workout : workouts) {
                for (Exercise exercise : this.workout.getExercises()) {
                    totalVolume += exercise.getVolume();
                }
            }
            System.out.println("Total volume lifted: " + totalVolume + " lbs");
        }
    }

}