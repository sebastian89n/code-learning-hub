package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.ScheduledTaskRequest;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses.TaskReply;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScheduledTaskProcessor implements TaskProcessor<ScheduledTaskRequest> {
    @Override
    public TaskReply processTask(final ScheduledTaskRequest task) {
        log.info("Starting to process scheduled task with uuid: {}", task.getUuid());
        // some complex logic
        final TaskReply taskReply = TaskReply.builder()
                .uuid(task.getUuid())
                .status(TaskReply.Status.SUCCESS)
                .build();

        log.info("Successfully processed task with uuid: {}", task.getUuid());

        return taskReply;
    }
}
