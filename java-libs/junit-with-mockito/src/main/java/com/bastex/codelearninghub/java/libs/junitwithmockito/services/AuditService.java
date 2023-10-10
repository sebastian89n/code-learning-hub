package com.bastex.codelearninghub.java.libs.junitwithmockito.services;

public interface AuditService {
    void addSaveNewEntryEvent(long newEntityId);

    void addUpdateNewEntryEvent(long newEntityId);

    void addNewDeletedEvent(long userId);
}
