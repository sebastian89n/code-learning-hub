package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.utils;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.NotificationTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.ScheduledTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.Task;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class TaskPreparator {
    static Task prepareScheduledTask(final String description, final LocalDate scheduledAt) {
        final ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setTaskUuid(UUID.randomUUID().toString());
        scheduledTask.setDescription(description);
        scheduledTask.setScheduledAt(scheduledAt);

        return scheduledTask;
    }

    static Task prepareNotificationTask(final String notification) {
        final NotificationTask scheduledTask = new NotificationTask();
        scheduledTask.setTaskUuid(UUID.randomUUID().toString());
        scheduledTask.setNotification(notification);

        return scheduledTask;
    }
}
