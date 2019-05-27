package me.eslamfathy.billionaire.utils;

public class OutputUtils {
    private MessageUtils messageUtils = new MessageUtils();

    public void display(String message) {
        System.out.println(message);
    }

    public void displayByMessageKey(String key, String... args) {
        display(messageUtils.getMessage(key, args));
    }

    public void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            LoggerUtils.getInstance().logError("Failed to sleep", e);
        }
    }
}
