package me.ltthanh.watcher.control;

import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.util.Objects;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

import me.ltthanh.bash.control.ExecuteBashService;
import me.ltthanh.config.entity.WatcherConfig;
import me.ltthanh.notification.control.WindowsNotificationService;

public class WatcherListener implements FileAlterationListener {

    private WatcherConfig watcherConfig;

    public WatcherListener(WatcherConfig watcherConfig) {
        Objects.requireNonNull(watcherConfig);
        this.watcherConfig = watcherConfig;
    }

    private void onAnyEventTriggered() {
        ExecuteBashService executeBashService = new ExecuteBashService();
        executeBashService.execute(watcherConfig.getBashScriptPath());

        if (watcherConfig.isNotification()) {
            WindowsNotificationService windowsNotificationService = new WindowsNotificationService();
            windowsNotificationService.sendNotification("Executed", "Your script was executed", MessageType.INFO);
        }
    }
    
    @Override
    public void onFileCreate(File file) {
        System.out.println("Detected a created event");
        onAnyEventTriggered();
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("Detected a deleted event");
        onAnyEventTriggered();
    }

    @Override
    public void onFileChange(File file) {
        System.out.println("Detected a changed event");
        onAnyEventTriggered();
    }

    @Override
    public void onStart(FileAlterationObserver observer) {
    }

    @Override
    public void onDirectoryCreate(File directory) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDirectoryChange(File directory) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDirectoryDelete(File directory) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStop(FileAlterationObserver observer) {
    }
}
