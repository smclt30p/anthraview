package io.github.smclt30p.anthraview.printer;

import io.github.smclt30p.anthraview.format.LogItem;

import java.io.File;

public class StandardPrinter extends Printer {

    @Override
    public void print() {
        LogItem[] items = getItems(new File("/home/gala/log"));
        for (LogItem i : items) {
            System.out.print(i.getLogMessage());
        }

    }

}
