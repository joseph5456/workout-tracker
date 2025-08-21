public class Set {
    private double weight;
    private int reps;

    public Set(double weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public double getVolume() {
        return weight * reps;
    }

    public String toString() {
        return weight + " lbs x " + reps + " reps";
    }
}