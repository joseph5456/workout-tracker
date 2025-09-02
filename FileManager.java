import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileManager {

    public void saveWorkout(Workout workout) {
           try (BufferedWriter writer = new BufferedWriter(new FileWriter("workouts.txt", true))) {
               writer.write("Workout:" + workout.getWorkoutName());
               writer.newLine();

               for (Exercise exercise : workout.getExercises()) {
                   writer.write("Exercise: " + exercise.getExerciseName());
                   writer.newLine();

                   for (Set set : exercise.getSets()) {
                       writer.write("Set:" + set.getWeight() + "," + set.getReps());
                       writer.newLine();
                   }
               }

               writer.write("---");
               writer.newLine();
           } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Load workouts into a list
    public ArrayList<Workout> loadWorkout() {
        ArrayList<Workout> workouts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("workouts.txt"))) {
            String line;
            Workout currentWorkout = null;
            Exercise currentExercise = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Workout:")) {
                    if (currentWorkout != null) {
                        workouts.add(currentWorkout);
                    }
                    String workoutName = line.substring(8).trim();
                    currentWorkout = new Workout(workoutName);

                } else if (line.startsWith("Exercise:")) {
                    String exerciseName = line.substring(9).trim();
                    currentExercise = new Exercise(exerciseName);
                    if (currentWorkout != null) {
                        currentWorkout.addExercise(currentExercise);
                    }

                } else if (line.startsWith("Set:")) {
                    String[] parts = line.substring(4).split(",");
                    double weight = Double.parseDouble(parts[0].trim());
                    int reps = Integer.parseInt(parts[1].trim());
                    if (currentExercise != null) {
                        currentExercise.addSet(weight, reps);
                    }

                } else if (line.equals("---")) {
                    if (currentWorkout != null) {
                        workouts.add(currentWorkout);
                        currentWorkout = null;
                    }
                }
            }

            if (currentWorkout != null) {
                workouts.add(currentWorkout);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No workouts found");
        } catch (IOException e ) {
            e.printStackTrace();
        }
        return workouts;
    }

    //clear all workouts
    public void clearWorkouts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("workouts.txt", false))) {
            //writing nothing resets the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}