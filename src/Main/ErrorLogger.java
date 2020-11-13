package Main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

public class ErrorLogger {
    private FileHandler fileHandler;
    private SimpleFormatter formatter;
    private LocalDateTime dateTime;

    public ErrorLogger() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.INFO);
        try{
            fileHandler = new FileHandler("Logg.txt");
        } catch (IOException e){
            System.out.println("Error creating file.");
            e.printStackTrace();
        }
        formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);

    }



}
