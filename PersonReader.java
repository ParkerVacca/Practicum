import java.io.*;
import java.nio.Buffer;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.BufferedReader;

import static java.nio.file.StandardOpenOption.CREATE;


public class PersonReader {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                System.out.println("ID#     FirstName     Lastname     Title     YOB");
                System.out.println("================================================");


                InputStream in =
                        new BufferedInputStream(Files.newInputStream(target, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                while(reader.ready())
                {line = reader.readLine();
                String [] values = line.split(",") ;
                System.out.print(values[0] + "   " + values[1] + "      " + values[2] + "     " + values[3] + "    "+ values[4]);


                }
                reader.close();

            } else {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);

            }
        }
            catch (FileNotFoundException e)
            {
                System.out.println("File Not Found Error")
                ;
            } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
