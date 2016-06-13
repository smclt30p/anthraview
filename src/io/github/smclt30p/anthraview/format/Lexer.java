package io.github.smclt30p.anthraview.format;

import io.github.smclt30p.anthraview.interfaces.LexerUtil;

public class Lexer implements LexerUtil {

    private int index;
    private final String[] fileChars;

    public Lexer(String[] fileChars) {
        this.fileChars = fileChars;
        this.index = -1;
    }

    @Override
    public boolean goForward() {
        int operator = index;
        if ((++operator) > this.fileChars.length - 1) {
            return false;
        }
        index = operator;
        return true;
    }

    @Override
    public boolean goBack() {
        int operator = index;
        if (operator < 0) {
            return false;
        }
        index--;
        return true;
    }

    @Override
    public String getChar() {
        return fileChars[index];
    }
    
    void reset() {
        this.index = -1;
    }
}
