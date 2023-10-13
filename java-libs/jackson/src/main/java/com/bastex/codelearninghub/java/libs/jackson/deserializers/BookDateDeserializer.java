package com.bastex.codelearninghub.java.libs.jackson.deserializers;

import com.bastex.codelearninghub.java.libs.jackson.utils.DateFormattingUtils;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;

public class BookDateDeserializer extends StdDeserializer<Instant> {
    protected BookDateDeserializer() {
        super(Instant.class);
    }

    @Override
    public Instant deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException, JacksonException {
        final String valueAsString = jsonParser.getValueAsString();
        if (valueAsString != null && !valueAsString.isEmpty()) {
            return DateFormattingUtils.parse(valueAsString);
        }

        return null;
    }
}
