package io.github.smclt30p.anthraview.commandline;

import io.github.smclt30p.anthraview.interfaces.Parameterized;

public class Parameter implements Parameterized {

    private String argument;
    private String parameter;

    Parameter(String argument, String parameter) {
        this.argument = argument;
        this.parameter = parameter;
    }

    @Override
    public String getArgument() { return this.argument; }

    @Override
    public String getParameter() {
        return this.parameter;
    }
}
