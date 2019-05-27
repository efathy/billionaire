package me.eslamfathy.billionaire.utils;

import me.eslamfathy.billionaire.model.Color;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OutputUtils {
    public static final String ANSI_RESET = "\u001B[0m";

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


    public void displayColoredStatement(Color color, String key, String... args) {
        display(color.getColourCode() + messageUtils.getMessage(key, args) + ANSI_RESET);
    }

    public void displayAsciiStatementByMessageKey(int size, String key, String... args) {
        displayAsciiStatement(size, messageUtils.getMessage(key, args));
    }

    public void displayAsciiStatement(int size, String statement) {
        int width = 100;
        int height = 25;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.PLAIN, size));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(statement, 5, 20);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? "$" : " ");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }
    }
}
