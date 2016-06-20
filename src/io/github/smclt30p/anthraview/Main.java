package io.github.smclt30p.anthraview;

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

import io.github.smclt30p.anthraview.commandline.Help;
import io.github.smclt30p.anthraview.commandline.Argument;
import io.github.smclt30p.anthraview.commandline.ArgumentParser;
import io.github.smclt30p.anthraview.printer.DmesgPrinter;
import io.github.smclt30p.anthraview.printer.HumanPrinter;
import io.github.smclt30p.anthraview.printer.Printer;
import io.github.smclt30p.anthraview.printer.StandardPrinter;

import java.io.File;

/**
 * Anthrazit Log Viewer main class.
 *
 * @author Ognjen galic
 * @since 1.0
 */
public class Main {

    /**
     * Anthrazit Log Viewer main entry method.
     * <br>
     * <b>Hierarchy of the program:</b>
     * <br>
     *     * Check if any argument are passed<br>
     *     * Check if help or version is passed<br>
     *     * Read log file name and check if it exists, read the log, check log for errors<br>
     *     * Check if dmesg is passed<br>
     *     * Check if human is passed<br>
     *     * Construct Printer based on parameters<br>
     *     * Check for color<br>
     *     * Print logs to console following color argument.<br>
     *
     * @param args command line arguments
     * @since 1.0
     */
    public static void main(String[] args) {

        if (args.length <= 0) {
            Help.printHelp();
        }

        Argument[] p = ArgumentParser.parse(args);

        if (ArgumentParser.checkForParameter(p, "version")) {
            Help.printVersion();
        } else if (ArgumentParser.checkForParameter(p, "help")) {
            Help.printHelp();
        }

        File log = new File(p[0].getArgument());
        Printer pr;

        if (ArgumentParser.checkForParameter(p, "dmesg")) {
            pr = new DmesgPrinter(log);
        } else if (ArgumentParser.checkForParameter(p, "human")) {
            pr = new HumanPrinter(log);
        } else {
            pr = new StandardPrinter(log);
        }

        if (ArgumentParser.checkForParameter(p, "color")) {
            pr.printColor();
        } else {
            pr.print();
        }

    }
}

