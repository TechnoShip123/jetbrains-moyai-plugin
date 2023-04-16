package com.technoship123.jetbrainsmoyaiplugin.listeners;

import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListenerAdapter;
import com.technoship123.jetbrainsmoyaiplugin.Moyai;
import org.jetbrains.annotations.NotNull;

/** This class listens for completed builds from <b>external</b> build systems (e.g. Gradle) */
public class ExternalTaskNotificationListener extends ExternalSystemTaskNotificationListenerAdapter {

    /** Play sound at the end of a task. */
    @Override
    public void onEnd(@NotNull ExternalSystemTaskId id) {
        super.onEnd(id);
        Moyai.playSound();
    }

}
