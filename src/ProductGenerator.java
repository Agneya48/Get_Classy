import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {

        ArrayList <Product> allProductRecs = new ArrayList<>();
        SafeInputObj in = new SafeInputObj();
        Product productRec;
        boolean done = false;

        String name = "";
        String description = "";
        double cost = 0.0;

        do {
            System.out.println();
            System.out.println("New Product Entry");
            name = in.getNonZeroLenString("Enter product name");
            description = in.getNonZeroLenString("Enter description");
            cost = in.getDouble("Enter cost");

            productRec = new Product(name, description, cost);

            System.out.println();
            System.out.println(productRec);
            System.out.println();

            done = in.getYNConfirm("Data entry complete? [Y/N]");

            allProductRecs.add(productRec);

        }while(!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\productTestData.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {

            for(Product rec : allProductRecs)
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
