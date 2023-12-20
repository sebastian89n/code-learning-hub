package com.bastex.codelearninghub.jakartaee.jsonb.adapters;

import jakarta.json.bind.adapter.JsonbAdapter;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class CertificationDateAdapter implements JsonbAdapter<Instant, String> {
    @Override
    public String adaptToJson(final Instant certificationDateInstant) {
        if (certificationDateInstant != null) {
            return DateTimeFormatter.ISO_INSTANT.format(certificationDateInstant);
        }
        return null;
    }

    @Override
    public Instant adaptFromJson(final String certificationDateInIsoFormat) {
        if (certificationDateInIsoFormat != null && !certificationDateInIsoFormat.isBlank()) {
            return Instant.from(DateTimeFormatter.ISO_INSTANT.parse(certificationDateInIsoFormat));
        }
        return null;
    }
}
