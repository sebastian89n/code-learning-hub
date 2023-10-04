package com.bastex.codelearninghub.testing.domain;

public record AuditEntry(Long updatedEventId, String message) {
}