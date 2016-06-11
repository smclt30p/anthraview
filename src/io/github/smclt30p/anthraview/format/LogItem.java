package io.github.smclt30p.anthraview.format;

public class LogItem {

    private long timeStamp;
    private String logMessage;
    private String logTag;
    private String logSeverity;

    public LogItem(long timeStamp,String logSeverity, String logTag, String logMessage) {
        this.timeStamp = timeStamp;
        this.logTag = logTag;
        this.logMessage = logMessage;
        this.logSeverity = logSeverity;
    }

    public String getLogTag() {
        return this.logTag;
    }
    public String getLogMessage() {
        return this.logMessage;
    }
    public long getTimeStamp() {
        return this.timeStamp;
    }
    public String getLogSeverity() {
        return this.logSeverity;
    }

}
