package com.bastex.codelearninghub.testing.services;

public interface AuditService {
    void addSaveNewEntryEvent(long newEntityId);

    void addUpdateNewEntryEvent(long newEntityId);
}
