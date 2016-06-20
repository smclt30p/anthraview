package io.github.smclt30p.anthraview.reader;

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


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * A character file reader.
 *
 * @author Ognjen Galic
 * @since 1.0
 */
public class FileReader {

    /**
     * Read the file from disk and return a UTF-8 encoded
     * string.
     *
     * @param file the file on disk.
     * @return the raw string of the file on disk encoded
     *         in UTF-8.
     */
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
