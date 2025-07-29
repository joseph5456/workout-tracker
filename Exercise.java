public class Exercise {
    String exerciseName;
    private int reps;
    private int sets;
    private int weight;

    public Exercise(String exerciseName, int sets, int reps, int weight) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }


    public String toString() {
        return "Exercise: " + exerciseName + "\nWeight: " +
                weight + "\nSets: " + sets + "\nReps: " + reps;
    }

}