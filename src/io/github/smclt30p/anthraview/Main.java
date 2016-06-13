package io.github.smclt30p.anthraview;

import io.github.smclt30p.anthraview.commandline.Help;
import io.github.smclt30p.anthraview.commandline.Parameter;
import io.github.smclt30p.anthraview.commandline.ParameterParser;

public class Main {

    public static void main(String[] args) {

        if (args.length <= 0) {
            Help.printHelp();
        }

        Parameter[] params = ParameterParser.parse(args);
        for (Parameter p : params) {
            if (p.getArgument().equals("help")) {
                Help.printHelp();
            } else if (p.getArgument().equals("version")) {
                Help.printVersion();
            }
        }
    }
}

