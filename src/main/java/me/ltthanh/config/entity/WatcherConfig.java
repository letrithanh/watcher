package me.ltthanh.config.entity;

import java.util.List;

public class WatcherConfig {
    
    private String bashScriptPath;

    private int pollIntervalInSecond;

    private List<String> observeredDirectories;

    public String getBashScriptPath() {
        return bashScriptPath;
    }

    public void setBashScriptPath(String bashScriptPath) {
        this.bashScriptPath = bashScriptPath;
    }

    public int getPollIntervalInSecond() {
        return pollIntervalInSecond;
    }

    public int getPollIntervalInMilisecond() {
        return pollIntervalInSecond * 1000;
    }

    public void setPollIntervalInSecond(int pollIntervalInSecond) {
        this.pollIntervalInSecond = pollIntervalInSecond;
    }

    public List<String> getObserveredDirectories() {
        return observeredDirectories;
    }

    public void setObserveredDirectories(List<String> observeredDirectories) {
        this.observeredDirectories = observeredDirectories;
    }

}
