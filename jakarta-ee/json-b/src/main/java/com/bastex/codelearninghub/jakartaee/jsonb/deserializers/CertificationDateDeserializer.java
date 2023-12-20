package com.bastex.codelearninghub.jakartaee.jsonb.deserializers;

import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class CertificationDateDeserializer implements JsonbDeserializer<Instant> {
    @Override
    public Instant deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext, final Type type) {
        final String dateString = jsonParser.getString();
        if (dateString != null) {
            return Instant.from(DateTimeFormatter.ISO_INSTANT.parse(dateString));
        } else {
            return null;
        }
    }
}
