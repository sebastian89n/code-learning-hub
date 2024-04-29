package com.bastex.codelearninghub.java.libs.jackson.databind.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomJsonToStringDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        return jsonParser.readValueAsTree().toString();
    }
}
