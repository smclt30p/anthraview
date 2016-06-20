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

/**
 * An abstract class to present POSIX-style
 * version and help info to the user.
 *
 * @author Ognjen Galic
 * @since 1.0
 */
public abstract class Help {

    private static final String HELP = "Usage: anthraview file --[ARGUMENT]=[PARAMETER] -- ...\n\n" +
            "View Anthrazit Logs, format then and convert to human readable formats.\n\n" +
            "\t--color - view logs in color (Supported on bash or zsh systems only)\n" +
            "\t--human - view logs with human readable timestamps\n" +
            "\t--dmesg - view log entries age in miliseconds from start\n" +
            "\t--when - view when log was created in human readable format\n\n";

    private static final String VERSION = "anthraview (Anthrazit) 1.0 build 219\n" +
            "Copyright (C) 2016 Free Time Foundation, Inc.\n" +
            "License GPLv2: GNU GPL version 2 <http://gnu.org/licenses/gpl.html>.\n" +
            "This is free software: you are free to change and redistribute it.\n" +
            "There is NO WARRANTY, to the extent permitted by law.\n" +
            "\n" +
            "Written by Ognjen Galić.\n";

    /**
     * Print the help and exit the program.
     *
     * @since 1.0
     */
    public static void printHelp() {
        System.out.print(HELP);
        System.exit(0);
    }

    /**
     * Print the version and exit the program.
     *
     * @since 1.0
     */
    public static void printVersion() {
        System.out.print(VERSION);
        System.exit(0);
    }

}



