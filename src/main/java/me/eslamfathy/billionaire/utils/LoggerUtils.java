package me.eslamfathy.billionaire.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtils {

    private Logger logger = null;
    private FileUtils fileUtils = new FileUtils();

    public LoggerUtils() {
        try {
            checkForLoggingFolder();
            FileHandler fileHandler = new FileHandler(Constants.LOGGER_ERROR_PATH + Constants.LOGGER_ERROR_FILE);
            logger = Logger.getLogger(Constants.LOGGER_CLASS_NAME);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logError(String message, Exception e) {
        if (logger != null) {
            logger.log(Level.SEVERE, message, e);
        }
    }

    private void checkForLoggingFolder() throws IOException {
        if (!fileUtils.isFolderExists(Constants.LOGGER_ERROR_PATH)) {
            fileUtils.createDirectory(Constants.LOGGER_ERROR_PATH);
        }
    }

}
