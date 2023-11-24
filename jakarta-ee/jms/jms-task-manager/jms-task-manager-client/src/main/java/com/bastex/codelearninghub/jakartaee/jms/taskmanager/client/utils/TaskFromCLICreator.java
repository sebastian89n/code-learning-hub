package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.utils;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.exceptions.CLIInputException;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.ScheduledTaskRequest;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.TaskRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Slf4j
public final class TaskFromCLICreator {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    private final Scanner scanner;

    public Optional<TaskRequest> createTaskFromUserInput() {
        log.info("Send a new task? [Y/N]");
        final String sendNewTask = scanner.nextLine();

        return switch (sendNewTask) {
            case "Y" -> prepareNewScheduledTask();
            case "N" -> Optional.empty();
            default -> throw new CLIInputException();
        };
    }

    private Optional<TaskRequest> prepareNewScheduledTask() {
        log.info("Provide task description: [non-empty]");

        final String taskDescriptionInput = scanner.nextLine();
        validateNonEmptyString(taskDescriptionInput);

        log.info("Provide scheduled date: [yyyy-mm-dd, current or future date]");
        final String scheduledAtInput = scanner.nextLine();
        if (scheduledAtInput == null || !DATE_PATTERN.matcher(scheduledAtInput).matches()) {
            throw new CLIInputException();
        }
        final LocalDate scheduledAt = LocalDate.parse(scheduledAtInput);
        if (scheduledAt.isBefore(LocalDate.now())) {
            throw new CLIInputException();
        }

        final TaskRequest scheduledTaskRequest = prepareNewScheduledTask(taskDescriptionInput, scheduledAt);
        return Optional.of(scheduledTaskRequest);
    }

    private static TaskRequest prepareNewScheduledTask(final String description, final LocalDate scheduledAt) {
        final ScheduledTaskRequest scheduledTask = new ScheduledTaskRequest();
        scheduledTask.setUuid(UUID.randomUUID().toString());
        scheduledTask.setDescription(description);
        scheduledTask.setScheduledAt(scheduledAt);

        return scheduledTask;
    }

    private static void validateNonEmptyString(final String taskNotification) {
        if (taskNotification == null || taskNotification.isBlank()) {
            throw new CLIInputException();
        }
    }
}
