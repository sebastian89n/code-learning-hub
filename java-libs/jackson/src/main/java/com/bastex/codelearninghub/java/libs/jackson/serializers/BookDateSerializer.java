package com.bastex.codelearninghub.java.libs.jackson.serializers;

import com.bastex.codelearninghub.java.libs.jackson.utils.DateFormatUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;

public class BookDateSerializer extends StdSerializer<Instant> {
    protected BookDateSerializer() {
        super(Instant.class);
    }

    @Override
    public void serialize(final Instant instant, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        if (instant != null) {
            jsonGenerator.writeString(DateFormatUtils.formatDate(instant));
        }
    }
}
