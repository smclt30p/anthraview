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

import io.github.smclt30p.anthraview.interfaces.Parameterized;

/**
 * This class presents a command line argument with
 * a parameter.
 *
 * @author Ognjen Galic
 * @since 1.0
 */
public class Argument implements Parameterized {

    private String argument;
    private String parameter;

    /**
     * Construct an argument with a parameter.
     *
     * @param argument The argument.
     * @param parameter The argument parameter
     */
    Argument(String argument, String parameter) {
        this.argument = argument;
        this.parameter = parameter;
    }

    /**
     * Get the argument string of this object.
     *
     * @return The argument.
     */
    @Override
    public String getArgument() { return this.argument; }

    /**
     * Get the argument parameter
     *
     * @return the argument parameter.
     */
    @Override
    public String getParameter() {
        return this.parameter;
    }
}
