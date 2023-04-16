package com.technoship123.jetbrainsmoyaiplugin.listeners;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.externalSystem.service.notification.ExternalSystemProgressNotificationManager;

public class AppListenerRegistration implements ApplicationComponent {
    private ExternalSystemProgressNotificationManager systemProgressNotificationManager;

    public AppListenerRegistration(ExternalSystemProgressNotificationManager externalNotificationsManager) {
        systemProgressNotificationManager = externalNotificationsManager;
    }

    @Override
    public void initComponent() {
        systemProgressNotificationManager.addNotificationListener(new ExternalTaskNotificationListener());
    }
}