/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christopher.testexcel;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

/**
 *
 * @author Chris
 */
public class AlarmManager {
    private TrayIcon trayIcon;

    public AlarmManager() {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("path/to/your/icon.png");
            trayIcon = new TrayIcon(image, "Alarm Notification");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Activity Due Soon");
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
            }
        }
    }

    public void showNotification(String title, String message) {
        if (trayIcon != null) {
            trayIcon.displayMessage(title, message, MessageType.INFO);
        }
    }
}