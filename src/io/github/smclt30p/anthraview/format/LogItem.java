package io.github.smclt30p.anthraview.format;

public class LogItem {

    private long timeStamp;
    private String logMessage;
    private String logTag;

    public LogItem(long timeStamp, String logTag, String logMessage) {
        this.timeStamp = timeStamp;
        this.logTag = logTag;
        this.logMessage = logMessage;
    }

    public String getLogTag() {
        return null;
    }
    public String getLogMessage() {
        return null;
    }
    public long getTimeStamp() {
        return 0;
    }

}
