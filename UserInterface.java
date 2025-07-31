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
            String input = scanner.nextLine();
            if (input.equals("yes")) {
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
                    exercises.add(exercise);
                    exerciseNum++;
                }
                break;

            } else if (input.equals("no")){
                System.out.println("You lazy bum!");
                break;
            }
        }

        if (!exercises.isEmpty()) {
            System.out.println("\nSummary: \n-------------------------");
            for (Exercise exercise : exercises) {
                System.out.println(exercise);
            }

            int totalVolume = 0;
            for (Exercise exercise : exercises) {
                totalVolume += exercise.getVolume();
            }
            System.out.println("Total volume lifted: " + totalVolume + " lbs");
        }
    }
}