package io.github.smclt30p.anthraview;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;

public class FileReader {

    private File file;
    private FileInputStream in;
    
    public String getLog(File file) {

        this.file = file;

        try {
            
            this.in = new FileInputStream(this.file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(); 

            byte[] buf = new byte[4096];
            int b;

            while ((b = this.in.read(buf)) != -1) {
                out.write(buf, 0, b);
            }

            this.in.close();
            out.close();

            return new String(out.toByteArray());
           
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
