package Main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ErrorLogger {
    private FileHandler fileHandler;
    private SimpleFormatter formatter;
    private Logger logger;

    public ErrorLogger() {
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
        logger.info("Failed to validate " + input);
    }



}
