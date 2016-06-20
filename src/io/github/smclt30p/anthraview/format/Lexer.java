package io.github.smclt30p.anthraview.format;

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

import io.github.smclt30p.anthraview.interfaces.LexerUtil;

/**
 * A Lexer to provide lexical analysis capabilities.
 *
 * @author Ognjen Galic
 * @since 1.0
 */
public class Lexer implements LexerUtil {

    private int index;
    private final String[] fileChars;

    /**
     * Construct a Lexer object with the characters of
     * the item beign analyzed.
     *
     * @param fileChars Array of characters of the item being analyzed.
     * @since 1.0
     */
    public Lexer(String[] fileChars) {
        this.fileChars = fileChars;
        this.index = -1;
    }

    /**
     * Go forward a character.
     *
     * @return true if there is a leading character, false if there is none.
     */
    @Override
    public boolean goForward() {
        int operator = index;
        if ((++operator) > this.fileChars.length - 1) {
            return false;
        }
        index = operator;
        return true;
    }

    /**
     * Go back a character.
     *
     * @return true if there is a trailing character, false if there is none.
     */
    @Override
    public boolean goBack() {
        int operator = index;
        if (operator < 0) {
            return false;
        }
        index--;
        return true;
    }

    /**
     * Get the character at the current index.
     *
     * @return the character at the current index.
     */
    @Override
    public String getChar() {
        return fileChars[index];
    }

    /**
     * Reset the lexer back to its initial state.
     */
    void reset() {
        this.index = -1;
    }
}
