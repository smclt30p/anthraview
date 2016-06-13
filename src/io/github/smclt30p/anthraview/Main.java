package io.github.smclt30p.anthraview;

import io.github.smclt30p.anthraview.commandline.Help;
import io.github.smclt30p.anthraview.commandline.Parameter;
import io.github.smclt30p.anthraview.commandline.ParameterParser;
import io.github.smclt30p.anthraview.printer.DmesgPrinter;
import io.github.smclt30p.anthraview.printer.HumanPrinter;
import io.github.smclt30p.anthraview.printer.Printer;
import io.github.smclt30p.anthraview.printer.StandardPrinter;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        if (args.length <= 0) {
            Help.printHelp();
        }

        Parameter[] p = ParameterParser.parse(args);

        if (ParameterParser.checkForParameter(p, "version")) {
            Help.printVersion();
        } else if (ParameterParser.checkForParameter(p, "help")) {
            Help.printHelp();
        }

        File log = new File(p[0].getArgument());
        Printer pr;

        if (ParameterParser.checkForParameter(p, "dmesg")) {
            pr = new DmesgPrinter(log);
        } else if (ParameterParser.checkForParameter(p, "human")) {
            pr = new HumanPrinter(log);
        } else {
            pr = new StandardPrinter(log);
        }

        if (ParameterParser.checkForParameter(p, "color")) {
            pr.printColor();
        } else {
            pr.print();
        }

    }
}

