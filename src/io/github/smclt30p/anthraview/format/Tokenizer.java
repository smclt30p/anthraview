package io.github.smclt30p.anthraview.format;

import java.io.File;

/*
 * Copyright (C) 2016  Ognjen Galić (smclt30p@gmail.com)
 *
 * This file is part of Anthraview.
 *
 * Anthraview is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, up to version 2 of the License.
 *
 * Anthraview is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Anthraview. If not, see <http://www.gnu.org/licenses/>.
*/

import io.github.smclt30p.anthraview.reader.FileReader;

/**
 * A class used to tokenize and analyze the log file on disk.
 *
 * @author Ognjen Galic
 * @since 1.0
 */
public class Tokenizer {

    private static final String ITEM_BREAK = "$";

    private final int numberOfItems;
    private final Lexer lexer;
    private final LogItem[] items;

    /**
     * Construct a new Tokenizer object from a file on disk.
     *
     * @param file the file on disk.
     * @since 1.0
     */
    public Tokenizer(File file) {

        this.lexer = new Lexer(new FileReader().getLog(file));
        this.numberOfItems = countItems();
        this.items = new LogItem[this.numberOfItems];

    }

    private int countItems() {

        int num = 0;

        while (this.lexer.goForward()) {
            if (this.lexer.getChar().equals(ITEM_BREAK)) {
                num++;
            }
        }
        this.lexer.reset();
        return num;

    }

    /**
     * Convert a log file to LogItem objects. Call this before calling getItems().
     *
     * @since 1.0
     */
    public void tokenize() {

        long time;
        String severity;
        String message;
        String logTag;
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < numberOfItems; i++ ) {

            /* Parsing epoch */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals("[")) {
                    while (this.lexer.goForward()) {
                        if (this.lexer.getChar().equals("]")) {
                            break;
                        } else {
                           token.append(this.lexer.getChar()); 
                        }
                    }
                } else {
                    System.err.println("Illegal start of log! Expected '[', found: " + this.lexer.getChar());
                    System.exit(1);
                }
            } else {
                System.out.println("Unexpected end of file!");
            }

            /* Finnish parsing epoch, reset token */

            time = Long.parseLong(token.toString());
            token = new StringBuilder();

            /* Parse severity tag */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals(" ") && this.lexer.goForward()) {
                   if (this.lexer.getChar().equals("{")) {
                       while (this.lexer.goForward()) {
                           if (this.lexer.getChar().equals("}")) {
                               break;
                            } else {
                                token.append(this.lexer.getChar());
                            }
                        }
                    }
                } else {
                    System.err.println("Unexpected token, expected whitespace, found: " + this.lexer.getChar());
                }
            }

            /* Finnish parsing severity tag, reset toktrailigen */

            severity = token.toString();
            token = new StringBuilder();

            /* Parse log tag */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals(" ")) {
                    while (this.lexer.goForward()) {
                        if (this.lexer.getChar().equals("%")) {
                            break;
                        } else {
                            token.append(this.lexer.getChar());
                        }
                    }
                } else {
                    System.err.println("Unexpected token, expected whitespace, found: " + this.lexer.getChar());
                }
            }

            /* Finnish parsing log tag, reset token */

            logTag = token.toString();
            token = new StringBuilder();

            /* Parse log message */

            if (this.lexer.goForward()) {
                if (this.lexer.getChar().equals(" ")) {
                    while (this.lexer.goForward()) {
                        if (this.lexer.getChar().equals("$")) {
                            break;
                        } else {
                            token.append(this.lexer.getChar());
                        }
                    }
                } else {
                    System.err.println("Unexpected token, expected whitespace, found: " + this.lexer.getChar());
                }
            }

            /* Finnish parsing message, reset token and finnih tokenizing */

            message = token.toString();
            token = new StringBuilder();
            
            this.items[i] = new LogItem(time, severity, logTag, message);

        }
    }

    /**
     * Return the log item objects from the log file.
     *
     * @return the log item objects.
     */
    public LogItem[] getItems() {
        return this.items;
    }
}
