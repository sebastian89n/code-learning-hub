package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.utils;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.exceptions.InvalidInputException;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.Task;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.TaskType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class TaskFromCLICreator {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    private static final Set<String> TASK_TYPES = Arrays.stream(TaskType.values())
            .map(TaskType::name)
            .sorted()
            .collect(Collectors.toCollection(LinkedHashSet::new));

    private final Scanner scanner;

    public Optional<Task> createTaskFromUserInput() {
        log.info("Send a new task? [Y/N]");
        final String sendNewTaskInput = scanner.nextLine();

        return switch (sendNewTaskInput) {
            case "Y" -> {
                log.info("Select task type {}", TASK_TYPES);
                final String taskTypeInput = scanner.nextLine();
                if (taskTypeInput == null || !TASK_TYPES.contains(taskTypeInput)) {
                    throw new InvalidInputException();
                } else {
                    yield prepareTask(taskTypeInput);
                }
            }
            case "N" -> Optional.empty();
            default -> throw new InvalidInputException();
        };
    }

    private Optional<Task> prepareTask(final String taskTypeInput) {
        final TaskType taskType = TaskType.valueOf(taskTypeInput);
        return switch (taskType) {
            case SCHEDULED_TASK -> prepareScheduledTask();
            case NOTIFICATION_TASK -> prepareNotificationTask();
        };
    }

    private Optional<Task> prepareScheduledTask() {
        log.info("Provide task description: [non-empty]");

        final String taskDescriptionInput = scanner.nextLine();
        validateNonEmptyString(taskDescriptionInput);

        log.info("Provide scheduled date: [yyyy-mm-dd]");
        final String scheduledAtInput = scanner.nextLine();
        if (scheduledAtInput == null || !DATE_PATTERN.matcher(scheduledAtInput).matches()) {
            throw new InvalidInputException();
        }
        final LocalDate scheduledAt = LocalDate.parse(scheduledAtInput);

        final Task scheduledTask = TaskPreparator.prepareScheduledTask(taskDescriptionInput, scheduledAt);
        return Optional.of(scheduledTask);
    }

    private Optional<Task> prepareNotificationTask() {
        log.info("Provide notification: [non-empty]");
        final String notification = scanner.nextLine();
        validateNonEmptyString(notification);

        final Task notificationTask = TaskPreparator.prepareNotificationTask(notification);
        return Optional.of(notificationTask);
    }

    private static void validateNonEmptyString(final String taskNotification) {
        if (taskNotification == null || taskNotification.isBlank()) {
            throw new InvalidInputException();
        }
    }
}
