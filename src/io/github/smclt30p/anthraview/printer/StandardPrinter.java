package io.github.smclt30p.anthraview.printer;

import io.github.smclt30p.anthraview.format.LogItem;

import java.io.File;

public class StandardPrinter extends Printer {

    private File log;

    public StandardPrinter(File log) {
        this.log = log;
    }

    @Override
    public void print() {
        LogItem[] items = getItems(log);
        StringBuilder builder = new StringBuilder();
        for (LogItem i : items) {
            builder.append("[")
                    .append(i.getTimeStamp())
                    .append("] (")
                    .append(i.getLogSeverity())
                    .append(") ")
                    .append(i.getLogTag())
                    .append(": ")
                    .append(i.getLogMessage());
        }

        System.out.print(builder.toString());

    }

    @Override
    public void printColor() {
        LogItem[] items = getItems(log);

        StringBuilder builder = new StringBuilder();

        for (LogItem i : items) {

            builder.append(ANSI_GREEN)
                    .append("[")
                    .append(i.getTimeStamp())
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

