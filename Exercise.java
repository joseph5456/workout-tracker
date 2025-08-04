public class Exercise {
    String exerciseName;
    private int reps;
    private int sets;
    private double weight;

    public Exercise(String exerciseName, int sets, int reps, double weight) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public double getVolume() {
        return sets * reps * weight;
    }


    public String toString() {
        return "Exercise: " + exerciseName + "\nBest Weight: " +
                weight + "\nBest Reps: " + reps +"\nSets: " + sets + "\n-------------------------";
    }

}