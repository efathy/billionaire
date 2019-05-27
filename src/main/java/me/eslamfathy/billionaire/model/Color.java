package me.eslamfathy.billionaire.model;

public enum Color {
    BLACK("\u001B[30m"), RED("\u001B[31m"), GREEN("\u001B[32m"), BLUE("\u001B[34m");

    private String colourCode;

    Color(String colourCode) {
        this.colourCode = colourCode;
    }

    public String getColourCode() {
        return colourCode;
    }
}
