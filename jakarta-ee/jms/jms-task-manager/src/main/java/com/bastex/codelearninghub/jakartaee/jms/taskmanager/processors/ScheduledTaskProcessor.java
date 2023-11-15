package com.bastex.codelearninghub.jakartaee.jms.taskmanager.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.ScheduledTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskReply;

public class ScheduledTaskProcessor implements TaskProcessor<ScheduledTask> {
    @Override
    public TaskReply processTask(final ScheduledTask task) {
        return null;
    }
}
