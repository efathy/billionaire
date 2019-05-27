package me.eslamfathy.billionaire.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtils {

    private Logger logger = null;
    private FileUtils fileUtils = new FileUtils();

    private static LoggerUtils loggerUtils;

    private LoggerUtils() {
        try {
            checkForLoggingFolder();
            FileHandler fileHandler = new FileHandler(Constants.LOGGER_ERROR_PATH + Constants.LOGGER_ERROR_FILE);
            SimpleFormatter formatterTxt = new SimpleFormatter();
            fileHandler.setFormatter(formatterTxt);
            logger = Logger.getLogger(Constants.LOGGER_CLASS_NAME);
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LoggerUtils getInstance() {
        if (loggerUtils == null) {
            loggerUtils = new LoggerUtils();
        }
        return loggerUtils;
    }

    public void logError(String message, Exception e) {
        if (logger != null) {
            logger.log(Level.SEVERE, message, e);
        }
    }

    public void logDebug(String message) {
        if (logger != null) {
            logger.log(Level.FINE, message);
        }
    }

    private void checkForLoggingFolder() throws IOException {
        if (!fileUtils.isFolderExists(Constants.LOGGER_ERROR_PATH)) {
            fileUtils.createDirectory(Constants.LOGGER_ERROR_PATH);
        }
    }

}
