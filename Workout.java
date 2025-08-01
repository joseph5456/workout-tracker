import java.util.ArrayList;

public class Workout {
    private String workoutName;
    private ArrayList<Exercise> exercises;

    public Workout(String workoutName) {
        this.workoutName = workoutName;
        this.exercises = new ArrayList<>();
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public String getWorkoutName() {
        return this.workoutName;
    }

}