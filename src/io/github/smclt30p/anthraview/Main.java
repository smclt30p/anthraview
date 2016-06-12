package io.github.smclt30p.anthraview;

import java.io.File;

import io.github.smclt30p.anthraview.format.Tokenizer;
import io.github.smclt30p.anthraview.format.LogItem;
import io.github.smclt30p.anthraview.reader.FileReader;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED_BRIGHT = "\u001B[1;31m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREY = "\u001B[37m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[1;37m";
    
    public static void main(String[] args) {

        Tokenizer token = new Tokenizer(new File("/home/gala/log"));
        LogItem[] items = token.getItems();

        String color;

        for (LogItem i : items) {
            switch (i.getLogSeverity()) {
                case "INFO":
                    color = ANSI_WHITE;
                    break;
                case "DEBUG":
                    color = ANSI_GREY;
                    break;
                case "ERROR":
                    color = ANSI_RED_BRIGHT;
                    break;
                case "EXCEPTION":
                case "FATAL":
                    color = ANSI_RED;
                    break;
                default:
                    color = ANSI_WHITE;
            }

            System.out.print(ANSI_GREEN + "[" + i.getTimeStamp() + "] " + ANSI_RESET +
                ANSI_YELLOW + i.getLogTag() + ": " + ANSI_RESET + color + i.getLogMessage() + ANSI_RESET);
            
        }
    }
}
