package io.github.smclt30p.anthraview.printer;

import io.github.smclt30p.anthraview.format.LogItem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HumanPrinter extends Printer {

    private File log;
    private SimpleDateFormat dateFormat;

    public HumanPrinter(File log) {
        this.log = log;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
    }

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
