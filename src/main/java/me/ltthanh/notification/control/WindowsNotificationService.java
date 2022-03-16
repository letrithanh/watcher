package me.ltthanh.notification.control;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.text.MessageFormat;

public class WindowsNotificationService {

    public void sendNotification(String title, String message, MessageType messageType) {
        if (!SystemTray.isSupported()) {
            System.out.println(MessageFormat.format("{0} - {1}. The toaster didn't appear because your system not support.", title, message));
        }

        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("unknown-image.png");
            TrayIcon trayIcon = new TrayIcon(image);
            trayIcon.setImageAutoSize(true);
            tray.add(trayIcon);
            trayIcon.displayMessage(title, message, messageType);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
