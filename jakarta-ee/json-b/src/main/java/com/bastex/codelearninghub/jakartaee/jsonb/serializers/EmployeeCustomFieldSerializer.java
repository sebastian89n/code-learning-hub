package com.bastex.codelearninghub.jakartaee.jsonb.serializers;

import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

public class EmployeeCustomFieldSerializer implements JsonbSerializer<String> {
    @Override
    public void serialize(final String s, final JsonGenerator jsonGenerator, final SerializationContext serializationContext) {

    }
}
