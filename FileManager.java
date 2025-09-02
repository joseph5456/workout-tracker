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
    public ArrayList<String> loadWorkout() {
        ArrayList<String> workouts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("workouts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                workouts.add(line);
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