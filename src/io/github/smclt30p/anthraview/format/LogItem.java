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

public class LogItem {

    private final long timeStamp;
    private final String logMessage;
    private final String logTag;
    private final String logSeverity;

    /**
     * An log item object. A log item object is consisted of a time stamp, a log
     * severity, a log tag and a log message.
     *
     * @param timeStamp the Unix epoch time im milliseconds
     * @param logSeverity the log severity. Supported is DEBUG, INFO, ERROR, FATAL and EXCEPTION.
     * @param logTag the logging tag. Should be all lowercase string describing the class or object
     *               from where the log item originated.
     * @param logMessage the logging message itself.
     */
    LogItem(long timeStamp,String logSeverity, String logTag, String logMessage) {
        this.timeStamp = timeStamp;
        this.logTag = logTag;
        this.logMessage = logMessage;
        this.logSeverity = logSeverity;
    }

    /**
     * Get the log tag of this log item object.
     *
     * @return the logging tag.
     */
    public String getLogTag() {
        return this.logTag;
    }

    /**
     * Get the log message of this log item object.
     *
     * @return the log message.
     */
    public String getLogMessage() {
        return this.logMessage;
    }

    /**
     * Get the time stamp of this log item object in Unix epoch
     * milliseconds.
     *
     * @return the time stamp.
     */
    public long getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * Get the log severity of this log item object.
     * Supported are DEBUG, INFO, ERROR, FATAL and EXCEPTION.
     *
     * @return log severity.
     */
    public String getLogSeverity() {
        return this.logSeverity;
    }

}
