package io.github.smclt30p.anthraview;

import java.io.File;

import io.github.smclt30p.anthraview.reader.Tokenizer;
import io.github.smclt30p.anthraview.format.LogItem;

public class Main {
    
    public static void main(String[] args) {

        Tokenizer token = new Tokenizer(new File("/home/gala/log"));
        LogItem[] items = token.getItems();

        for (LogItem i : items) {
            System.out.print("[" + i.getTimeStamp() + "] " + i.getLogTag() + ": " + i.getLogMessage());
        }


    }

}
