package me.eslamfathy.billionaire.utils;

import java.util.Scanner;

public class InputUtils {

    private Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.nextLine();
    }

    public Integer readInteger() {
        return scanner.nextInt();
    }
}
