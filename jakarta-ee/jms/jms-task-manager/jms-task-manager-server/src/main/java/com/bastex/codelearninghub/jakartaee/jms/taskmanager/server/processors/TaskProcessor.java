package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.TaskRequest;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses.TaskReply;

public interface TaskProcessor<T extends TaskRequest> {
    TaskReply processTask(T task);
}
