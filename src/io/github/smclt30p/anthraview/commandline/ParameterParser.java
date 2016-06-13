package io.github.smclt30p.anthraview.commandline;

import io.github.smclt30p.anthraview.format.Lexer;

public abstract class ParameterParser {

    public static Parameter[] parse(String[] params) {

        Parameter[] parameters = new Parameter[params.length];

        for (int j = 0; j < params.length; j++) {

            char[] chars = params[j].toCharArray();
            String[] charString = new String[chars.length];

            for (int i = 0; i < chars.length; i++) {
                charString[i] = String.valueOf(chars[i]);
            }

            Lexer lexer = new Lexer(charString);
            StringBuilder token = new StringBuilder();

            if (lexer.goForward() && lexer.getChar().equals("-") && lexer.goForward() && lexer.getChar().equals("-")) {
                while (lexer.goForward()) {
                    if (lexer.getChar().equals("=")) {
                        break;
                    } else {
                        token.append(lexer.getChar());
                    }
                }
            } else {
                System.err.print("Invalid argument start! " + lexer.getChar() + ", arguments are in the format " +
                        "--argument=parameter");
                System.exit(1);
            }

            String argument = token.toString();

            token = new StringBuilder();

            if (lexer.getChar().equals("=")) {
                while (lexer.goForward()) {
                    token.append(lexer.getChar());
                }
            }

            String param = token.toString();

            parameters[j] = new Parameter(argument, param);

        }
        return parameters;
    }
}

