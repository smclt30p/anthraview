package io.github.smclt30p.anthraview.commandline;

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

import io.github.smclt30p.anthraview.format.Lexer;

/**
 * This class is used to parse arguments from the command line.
 *
 * Arguments are in the form of --argument=parameter.
 *
 * @author Ognjen Galic
 * @since 1.0
 */
public abstract class ArgumentParser {

    /**
     * Parse arguments from the command line.
     *
     * @param params The args array from main
     * @return Array of Argument objects
     * @since 1.0
     */
    public static Argument[] parse(String[] params) {

        Argument[] arguments = new Argument[params.length];

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
            } else if (j == 0) {
                arguments[0] = new Argument(params[0], null);
                continue;
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

            arguments[j] = new Argument(argument, param);

        }
        return arguments;
    }

    /**
     * Check if a certain parameter is passed to the program.
     *
     * @param params Array of Parameter objects.
     * @param key Search for the key in the parameters.
     * @return true if the key is preset, false if not.
     * @since 1.0
     */
    public static boolean checkForParameter(Argument[] params, String key) {
        for (Argument p : params) {
            if (p.getArgument().equals(key)) {
                return true;
            }
        }
        return false;
    }
}

