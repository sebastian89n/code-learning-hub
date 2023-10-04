package com.bastex.codelearninghub.testing.services;

import java.util.ArrayList;
import java.util.List;

public class AuditInMemoryService implements AuditService {
    private final List<String> events = new ArrayList<>();

    @Override
    public void addSaveNewEntryEvent(final long newEntityId) {

    }

    @Override
    public void addUpdateNewEntryEvent(final long newEntityId) {

    }
}
