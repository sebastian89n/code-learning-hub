package com.bastex.codelearninghub.jakartaee.jms.taskmanager.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.Task;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskReply;

public interface TaskProcessor<T extends Task> {
    TaskReply processTask(T task);
}
