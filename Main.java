import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Writing to a file.");
            writer.write("\nAnother line");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserInterface ui = new UserInterface(scanner);


        ui.start();
    }
}