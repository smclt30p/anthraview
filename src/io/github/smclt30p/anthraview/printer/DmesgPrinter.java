package io.github.smclt30p.anthraview.printer;

import io.github.smclt30p.anthraview.format.LogItem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DmesgPrinter extends Printer {

    private File log;
    private SimpleDateFormat dateFormat;

    public DmesgPrinter(File log) {
        this.log = log;
        this.dateFormat = new SimpleDateFormat("ssss.SSSS");
    }

    @Override
    public void print() {
        LogItem[] items = getItems(log);
        StringBuilder builder = new StringBuilder();
        Date date;
        long start = 0;

        for (int i = 0; i < items.length; i++) {

            if (i == 0) {
                start = items[0].getTimeStamp();
            }

            date = new Date(items[i].getTimeStamp() - start);

            builder.append("[")
                    .append(dateFormat.format(date))
                    .append("] (")
                    .append(items[i].getLogSeverity())
                    .append(") ")
                    .append(items[i].getLogTag())
                    .append(": ")
                    .append(items[i].getLogMessage());
        }

        System.out.print(builder.toString());

    }

    @Override
    public void printColor() {
        LogItem[] items = getItems(log);
        StringBuilder builder = new StringBuilder();
        Date date;
        long start = 0;

        for (int i = 0; i < items.length; i++) {

            if (i == 0) {
                start = items[0].getTimeStamp();
            }

            date = new Date(items[i].getTimeStamp() - start);
            builder.append(ANSI_GREEN)
                    .append("[")
                    .append(dateFormat.format(date))
                    .append("] ")
                    .append(ANSI_RESET)
                    .append(ANSI_YELLOW)
                    .append(items[i].getLogTag())
                    .append(": ")
                    .append(ANSI_RESET)
                    .append(getColor(items[i].getLogSeverity()))
                    .append(items[i].getLogMessage())
                    .append(ANSI_RESET);

        }

        System.out.print(builder.toString());

    }

}
