package me.ltthanh.watcher.control;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import me.ltthanh.config.control.ConfigReader;
import me.ltthanh.config.entity.WatcherConfig;

public class WatcherRegister {
    
    public void register(String jsonConfigPath) throws Exception {
        ConfigReader configReader = new ConfigReader();
        WatcherConfig watcherConfig = configReader.load(jsonConfigPath);
        FileAlterationMonitor monitor = registerDirectories(watcherConfig);
        monitor.start();
    }

    private FileAlterationMonitor registerDirectories(WatcherConfig watcherConfig) {
        FileAlterationMonitor monitor = new FileAlterationMonitor(watcherConfig.getPollIntervalInMilisecond());
        for (String directory: watcherConfig.getObserveredDirectories()) {
            FileAlterationObserver observer = new FileAlterationObserver(directory);
            FileAlterationListener listener = new WatcherListener(watcherConfig.getBashScriptPath());
            observer.addListener(listener);
            monitor.addObserver(observer);
        }
        return monitor;
    }

}
