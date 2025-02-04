import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {

        ArrayList <Person>allPersonRecs = new ArrayList<>();
        SafeInputObj in = new SafeInputObj();
        boolean done = false;


        String firstName;
        String lastName;
        String title;
        int yearOfBirth;

        do {
            System.out.println();
            System.out.println("New Person Entry");
            firstName = in.getNonZeroLenString("Enter first name");
            lastName = in.getNonZeroLenString("Enter last name");
            title = in.getNonZeroLenString("Enter their title");
            yearOfBirth = in.getRangedInt("Enter the year of birth", 1940, 2010);

            Person personRec = new Person(firstName, lastName, title, yearOfBirth);
            System.out.println();
            System.out.println(personRec);
            System.out.println();

            done = in.getYNConfirm("Data entry complete? [Y/N]");

            allPersonRecs.add(personRec);

        }while(!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personTestData.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {

            for(Person rec : allPersonRecs)
            {
                String csvRec = rec.toCSVRecord();
                writer.write(csvRec, 0, csvRec.length());
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}