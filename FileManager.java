import java.io.*;

public class FileManager {

    public void saveWorkout(String workout) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("workouts.txt"));
            writer.write(workout + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadWorkout() {
        try (BufferedReader reader = new BufferedReader(new FileReader("workouts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Loaded: " + line);
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}