package io.github.smclt30p.anthraview.printer;

import io.github.smclt30p.anthraview.format.LogItem;
import io.github.smclt30p.anthraview.format.Tokenizer;

import java.io.File;

abstract class Printer {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED_BRIGHT = "\u001B[1;31m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_GREY = "\u001B[37m";
    static final String ANSI_WHITE = "\u001B[1;37m";

    LogItem[] getItems(File file) {
        Tokenizer tokenizer = new Tokenizer(file);
        return tokenizer.getItems();
    }

    public abstract void print();
    public abstract void printColor();

}