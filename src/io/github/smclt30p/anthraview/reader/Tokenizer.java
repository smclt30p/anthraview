package io.github.smclt30p.anthraview.reader;

import java.util.ArrayList;
import java.io.File;

import io.github.smclt30p.anthraview.format.LogItem;

public class Tokenizer {

    private static final String ITEM_BREAK = "$";

    private int numberOfItems;
    private Lexer lexer;
    private LogItem[] items;

    public Tokenizer(File file) {

        this.lexer = new Lexer(new FileReader().getLog(file));
        this.numberOfItems = countItems(ITEM_BREAK);
        this.items = new LogItem[this.numberOfItems];

        tokenize();

    }

    private int countItems(String itemBreak) {

        int num = 0;

        while (this.lexer.goForward()) {
            if (this.lexer.getChar().equals(ITEM_BREAK)) {
                num++;
            }
        }
        this.lexer.reset();
        return num;

    }

    public void tokenize() {

        for (int i = 0; i < 1; i++ ) {
            System.out.println("doing it...");

            
            long time;
            String message;
            String tag;
            String token = "";


            while (this.lexer.goForward()) {
                System.out.println("Reading");
                if (this.lexer.getChar().equals("[")) {
                    while (this.lexer.goForward()) {
                        if (this.lexer.getChar().equals("]")) {
                            break;
                        } else {
                           token += this.lexer.getChar(); 
                        }
                    }
                    break;
                } else {
                    System.err.println("Illegal start of log!");
                }
            }

            System.out.println(token);


        }

    }

}
