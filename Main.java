import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);

        //bufferedwriter: allows you to write into files
        /*try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/jnguyen/Desktop/Test/output.txt"));
            writer.write("karen");
            writer.write("\nchad");
            writer.write("\nbecky");
            writer.close();
        } catch (Exception ex) {
            return;
        }


        //reads file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/jnguyen/Desktop/Test/output.txt"));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            reader.close();
        } catch(Exception ex) {
            return;
        }

        UserInterface ui = new UserInterface(scanner);*/


        ui.start();
    }
}