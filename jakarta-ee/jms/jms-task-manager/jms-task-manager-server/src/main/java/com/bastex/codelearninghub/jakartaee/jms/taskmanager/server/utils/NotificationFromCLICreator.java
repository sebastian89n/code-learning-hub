package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.utils;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.exceptions.TaskManagerCLIInputException;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.notifications.ServerNotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public final class NotificationFromCLICreator {
    private final Scanner scanner;

    public Optional<ServerNotificationMessage> createNotificationFromUserInput() {
        log.info("Send a notification to all connected clients? [Y/N]");
        final String sendNotification = scanner.nextLine();
        return switch (sendNotification) {
            case "Y" -> prepareNewNotification();
            case "N" -> Optional.empty();
            default -> throw new TaskManagerCLIInputException();
        };
    }

    private Optional<ServerNotificationMessage> prepareNewNotification() {
        log.info("Provide notification message: [non-empty]");
        final String notificationMessage = scanner.nextLine();
        if (notificationMessage == null || notificationMessage.isBlank()) {
            throw new TaskManagerCLIInputException();
        }

        final String uuid = UUID.randomUUID().toString();
        final ServerNotificationMessage serverNotificationMessage = new ServerNotificationMessage(uuid, notificationMessage);
        return Optional.of(serverNotificationMessage);
    }
}
