package me.eslamfathy.billionaire.utils;

import java.util.ResourceBundle;

public class MessageUtils {

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    public String getMessage(String key, String... args) {
        return String.format(resourceBundle.getString(key), args);
    }
}
