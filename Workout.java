import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Workout {
    private String workoutName;
    private ArrayList<Exercise> exercises;
    private String workoutTime;

    public Workout(String workoutName) {
        this.workoutName = workoutName;
        this.exercises = new ArrayList<>();
        this.workoutTime = new SimpleDateFormat("EEE, MMM d, yyyy").format(Calendar.getInstance().getTime());
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }

    public void printExercises() {
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public String getWorkoutName() {
        return this.workoutName;
    }

    public String getWorkoutTime() {
        return this.workoutTime;
    }


    public String toString() {
        return "Workout: " + this.workoutName + " (" + this.workoutTime + ")";
    }

}