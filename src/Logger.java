import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private File loggFile;
    private LocalDateTime dateTime;
    private BufferedWriter bufferedWriter;

    public void createFile(){
        try {
            loggFile = new File("loggfile.txt");
            loggFile.createNewFile();
        } catch (IOException e){
            System.out.println("Error creating file.");
            e.printStackTrace();
        }
    }

    public void loggData(String data){
        dateTime = LocalDateTime.now();
        try {
            createFile();
            bufferedWriter = new BufferedWriter(new FileWriter("loggfile.txt", true));
            bufferedWriter.append(dateTime + ": Failed validation, input data was - " + data);
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println(dateTime + ": " + data);
        } catch (IOException e){
            System.out.println("Error writing to file");
            e.printStackTrace();
        }

    }
}
