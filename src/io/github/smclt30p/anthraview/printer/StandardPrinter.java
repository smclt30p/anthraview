package io.github.smclt30p.anthraview.printer;

import io.github.smclt30p.anthraview.format.LogItem;

import java.io.File;

public class StandardPrinter extends Printer {

    @Override
    public void print() {
        LogItem[] items = getItems(new File("/home/gala/log"));
        StringBuilder builder = new StringBuilder();
        for (LogItem i : items) {
            builder.append("[")
                    .append(i.getTimeStamp())
                    .append("] ")
                    .append(i.getLogSeverity())
                    .append(": ")
                    .append(i.getLogTag())
                    .append(": ")
                    .append(i.getLogMessage());
        }

        System.out.print(builder.toString());

    }

    @Override
    public void printColor() {
       LogItem[] items = getItems(new File("/home/gala/log"));
        StringBuilder builder = new StringBuilder();
        String color;
        for (LogItem i : items) {
            String tag = i.getLogSeverity();
            switch (tag) {
                case "INFO":
                    color = ANSI_WHITE;
                    break;
                case "ERROR":
                    color = ANSI_RED_BRIGHT;
                    break;
                case "FATAL":
                case "EXCEPTION":
                    color = ANSI_RED;
                    break;
                case "DEBUG":
                    color = ANSI_GREY;
                    break;
                default: // Should not happen
                    color = ANSI_WHITE;
                    break;
            }
            builder.append(ANSI_GREEN)
                    .append("[")
                    .append(i.getTimeStamp())
                    .append("] ")
                    .append(ANSI_RESET)
                    .append(ANSI_YELLOW)
                    .append(i.getLogTag())
                    .append(": ")
                    .append(ANSI_RESET)
                    .append(color)
                    .append(i.getLogMessage())
                    .append(ANSI_RESET);
        }

        System.out.print(builder.toString());
    }

}

