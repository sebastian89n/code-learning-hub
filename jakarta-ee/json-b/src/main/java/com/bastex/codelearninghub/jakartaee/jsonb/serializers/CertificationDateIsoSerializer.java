package com.bastex.codelearninghub.jakartaee.jsonb.serializers;

import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class CertificationDateIsoSerializer implements JsonbSerializer<Instant> {
    @Override
    public void serialize(final Instant certificationDate, final JsonGenerator jsonGenerator, final SerializationContext serializationContext) {
        if (certificationDate != null) {
            final String formattedDate = DateTimeFormatter.ISO_INSTANT.format(certificationDate);
            jsonGenerator.write(formattedDate);
        }
    }
}
