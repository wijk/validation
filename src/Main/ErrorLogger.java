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
    private Logger logger;

    public ErrorLogger() throws IOException {
        this.logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
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

    public void loggError(String input){
        dateTime = LocalDateTime.now();
        logger.info(dateTime + ": failed to validate " + input);
    }



}
