package io.github.smclt30p.anthraview.printer;

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

import io.github.smclt30p.anthraview.format.LogItem;
import io.github.smclt30p.anthraview.format.Tokenizer;

import java.io.File;

/**
 * An abstract class partially implementing a printer
 * and describing a printer behaviour.
 *
 * A printer is an object used to print logs
 * to the command line.
 *
 * @author Ognjen Galic
 * @since 1.0
 */
public abstract class Printer {

    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RESET = "\u001B[0m";

    private static final String ANSI_RED_BRIGHT = "\u001B[1;31m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREY = "\u001B[37m";
    private static final String ANSI_WHITE = "\u001B[1;37m";

    /**
     * Load the log file into the printer using a Tokenizer.
     *
     * @param file the log file.
     * @return the log item objects.
     * @since 1.0
     */
    LogItem[] getItems(File file) {
        Tokenizer tokenizer = new Tokenizer(file);
        tokenizer.tokenize();
        return tokenizer.getItems();
    }

    /**
     * Return the message color based on the log severity.
     * If an unknown severity is passed, the default color is
     * return, which is bright white.
     *
     * @param tag the log severity tag.
     * @return the color.
     * @since 1.0
     */
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

    /**
     * Define a behaviour in which the log messages get
     * printed out without any coloring.
     *
     * @since 1.0
     */
    public abstract void print();

    /**
     * Define a behaviour in which the log messages get
     * printed out with coloring based on the log
     * severity.
     *
     * @since 1.0
     */
    public abstract void printColor();

}