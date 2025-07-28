public class Exercise {
    String exerciseName;
    private int reps;
    private int sets;

    public Exercise(String exerciseName, int sets, int reps) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
    }
}