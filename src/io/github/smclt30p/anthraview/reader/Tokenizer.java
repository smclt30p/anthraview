package io.github.smclt30p.anthraview.reader;

import java.util.ArrayList;
import java.io.File;

import io.github.smclt30p.anthraview.format.LogItem;

public class Tokenizer {

    private static final String ITEM_BREAK = "$";

    private int numberOfItems;
    private Lexer lexer;

    public Tokenizer(File file) {

        this.lexer = new Lexer(new FileReader().getLog(file));
        this.numberOfItems = countItems(ITEM_BREAK);

    }

    private int countItems(String itemBreak) {

        int num = 0;

        while (this.lexer.goForward()) {
            if (this.lexer.getChar().equals(ITEM_BREAK)) {
                num++;
            }
        }

        return num;

    }

}
