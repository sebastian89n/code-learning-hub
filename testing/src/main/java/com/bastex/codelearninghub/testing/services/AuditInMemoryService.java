package com.bastex.codelearninghub.testing.services;

import java.util.ArrayList;
import java.util.List;

public class AuditInMemoryService implements AuditService {
    private final List<String> events = new ArrayList<>();

    @Override
    public void addSaveNewEntryEvent(final long newEntityId) {
        events.add("Added new entity with id " + newEntityId);
    }

    @Override
    public void addUpdateNewEntryEvent(final long newEntityId) {
        events.add("Updated entity with id " + newEntityId);
    }

    @Override
    public void addNewDeletedEvent(final long userId) {
        events.add("Deleted entity with id " + userId);
    }
}
