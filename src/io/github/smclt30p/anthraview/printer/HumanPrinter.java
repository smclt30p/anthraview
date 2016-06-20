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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An class implementing a printer which prints
 * logs in a human readable format. It presents
 * log timestamps in the following format:
 *
 * dd/MM/yyyy hh:mm:ss:SSS
 *
 * @author Ognjen Galic
 * @since 1.0
 * @see io.github.smclt30p.anthraview.printer.Printer
 */
public class HumanPrinter extends Printer {

    private File log;
    private SimpleDateFormat dateFormat;

    /**
     * Construct a printer which provides human readable
     * time stamp formats.
     *
     * @param log the log file.
     * @since 1.0
     */
    public HumanPrinter(File log) {
        this.log = log;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
    }

    /**
     * Print a human readable representation of the
     * log to the console without any coloring.
     *
     * @since 1.0
     */
    @Override
    public void print() {
        LogItem[] items = getItems(log);
        StringBuilder builder = new StringBuilder();
        Date date;
        for (LogItem i : items) {
            date = new Date(i.getTimeStamp());
            builder.append("[")
                    .append(dateFormat.format(date))
                    .append("] (")
                    .append(i.getLogSeverity())
                    .append(") ")
                    .append(i.getLogTag())
                    .append(": ")
                    .append(i.getLogMessage());
        }

        System.out.print(builder.toString());

    }

    /**
     * Print a human readable representation of the
     * log to the console with coloring based on
     * the severity of the log entry.
     *
     * @since 1.0
     */
    @Override
    public void printColor() {

        LogItem[] items = getItems(log);
        StringBuilder builder = new StringBuilder();
        Date date;

        for (LogItem i : items) {
            date = new Date(i.getTimeStamp());

            builder.append(ANSI_GREEN)
                    .append("[")
                    .append(dateFormat.format(date))
                    .append("] ")
                    .append(ANSI_RESET)
                    .append(ANSI_YELLOW)
                    .append(i.getLogTag())
                    .append(": ")
                    .append(ANSI_RESET)
                    .append(getColor(i.getLogSeverity()))
                    .append(i.getLogMessage())
                    .append(ANSI_RESET);
        }

        System.out.print(builder.toString());

    }

}
