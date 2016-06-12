package io.github.smclt30p.anthraview.format;

import java.util.ArrayList;
import java.io.File;

import io.github.smclt30p.anthraview.reader.FileReader;

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

        long time;
        String severity;
        String message;
        String logTag;
        String token = "";

        for (int i = 0; i < numberOfItems; i++ ) {

            /* Parsing epoch */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals("[")) {
                    while (this.lexer.goForward()) {
                        if (this.lexer.getChar().equals("]")) {
                            break;
                        } else {
                           token += this.lexer.getChar(); 
                        }
                    }
                } else {
                    System.err.println("Illegal start of log! Expected '[', found: " + this.lexer.getChar());
                }
            } else {
                System.out.println("Unexcpeted end of file!");
            }

            /* Finnish parsing epoch, reset token */

            time = Long.parseLong(token);
            token = "";

            /* Parse severity tag */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals(" ") && this.lexer.goForward()) {
                   if (this.lexer.getChar().equals("{")) {
                       while (this.lexer.goForward()) {
                           if (this.lexer.getChar().equals("}")) {
                               break;
                            } else {
                                token += this.lexer.getChar();
                            }
                        }
                    }
                } else {
                    System.err.println("Unexpected token, expected whitespace, found: " + this.lexer.getChar());
                }
            }

            /* Finnish parsing severity tag, reset token */

            severity = token;
            token = "";

            /* Parse log tag */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals(" ")) {
                    while (this.lexer.goForward()) {
                        if (this.lexer.getChar().equals("%")) {
                            break;
                        } else {
                            token += this.lexer.getChar();
                        }
                    }
                } else {
                    System.err.println("Unexpected token, expected whitespace, found: " + this.lexer.getChar());
                }
            }

            /* Finnish parsing log tag, reset token */

            logTag = token;
            token = "";

            /* Parse log message */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals(" ")) {
                    while (this.lexer.goForward()) {
                        if (this.lexer.getChar().equals("$")) {
                            break;
                        } else {
                            token += this.lexer.getChar();
                        }
                    }
                } else {
                    System.err.println("Unexpected token, expected whitespace, found: " + this.lexer.getChar());
                }
            }

            /* Finnish parsing message, reset token and finnih tokenizing */

            message = token;
            token = "";
            
            this.items[i] = new LogItem(time, severity, logTag, message);

        }
    }

    public LogItem[] getItems() {
        return this.items;
    }
}
