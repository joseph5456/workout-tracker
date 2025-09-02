import java.util.ArrayList;

public class Exercise {
    private String exerciseName;
    private ArrayList<Set> sets;

    public Exercise(String exerciseName) {
        this.exerciseName = exerciseName;
        this.sets = new ArrayList<>();
    }

    public void addSet(double weight, int reps) {
        sets.add(new Set(weight, reps));
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }
    public double getVolume() {
        double total = 0;
        for (Set s : sets) {
            total += s.getVolume();
        }
        return total;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exercise: ").append(exerciseName).append("\n");
        int i = 1;
        for (Set s : sets) {
            sb.append("\tSet ").append(i++).append(": ").append(s).append("\n");
        }
        sb.append("\tVolume: ").append(getVolume()).append(" lbs\n").append("-------------------------");
        return sb.toString();
    }

}