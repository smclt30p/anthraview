package io.github.smclt30p.anthraview;

import java.io.File;

import io.github.smclt30p.anthraview.reader.FileReader;

public class Main {
    
    public static void main(String[] args) {

        FileReader reader = new FileReader();
        String log = reader.getLog(new File("/home/gala/log"));
        System.out.println(log);

    }

}
