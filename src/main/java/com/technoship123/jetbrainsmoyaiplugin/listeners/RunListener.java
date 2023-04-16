package com.technoship123.jetbrainsmoyaiplugin.listeners;

import com.intellij.execution.ExecutionListener;
import com.intellij.execution.ExecutionManager;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.project.Project;
import com.intellij.util.messages.MessageBusConnection;
import com.technoship123.jetbrainsmoyaiplugin.Moyai;
import org.jetbrains.annotations.NotNull;


/** Listens for run button press, only plays sound after the run process is terminated. */
public class RunListener {
    private MessageBusConnection messageBusConnection;

    public RunListener(Project project) {
        messageBusConnection = project.getMessageBus().connect();
        messageBusConnection.subscribe(ExecutionManager.EXECUTION_TOPIC, new ExecutionListener() {
            /** Place sound effect after the run process is terminated. */
            @Override
            public void processTerminated(@NotNull String executorId, @NotNull ExecutionEnvironment env, @NotNull ProcessHandler handler, int exitCode) {
                Moyai.playSound();
            }
        });
    }
}
