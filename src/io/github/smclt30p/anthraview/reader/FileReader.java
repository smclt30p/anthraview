package io.github.smclt30p.anthraview.reader;

import java.io.*;

import java.nio.charset.StandardCharsets;

public class FileReader {

    public String[] getLog(File file) {

        try {
            
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(); 

            byte[] buf = new byte[4096];
            int b;

            while ((b = in.read(buf)) != -1) {
                out.write(buf, 0, b);
            }

            in.close();
            out.close();

            String raw = new String(out.toByteArray(), StandardCharsets.UTF_8);
            char[] charArray = raw.toCharArray();
            String[] stringCharArray = new String[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                stringCharArray[i] = String.valueOf(charArray[i]);
            }

            return stringCharArray;
           
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
            System.exit(1);
        } 
        throw new RuntimeException("General file reader error!");
    }
}
