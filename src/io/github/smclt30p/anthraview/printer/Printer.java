package io.github.smclt30p.anthraview.printer;

import io.github.smclt30p.anthraview.format.LogItem;
import io.github.smclt30p.anthraview.format.Tokenizer;

import java.io.File;

public abstract class Printer {

    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RESET = "\u001B[0m";

    private static final String ANSI_RED_BRIGHT = "\u001B[1;31m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREY = "\u001B[37m";
    private static final String ANSI_WHITE = "\u001B[1;37m";

    LogItem[] getItems(File file) {
        Tokenizer tokenizer = new Tokenizer(file);
        return tokenizer.getItems();
    }

    String getColor(String tag) {
        switch (tag) {
            case "INFO":
                return ANSI_WHITE;
            case "ERROR":
                return ANSI_RED;
            case "FATAL":
            case "EXCEPTION":
                return ANSI_RED_BRIGHT;
            case "DEBUG":
                return ANSI_GREY;
            default: // Should not happen
                return ANSI_WHITE;
        }
    }

    public abstract void print();
    public abstract void printColor();

}