package com.bastex.codelearninghub.java.libs.jackson.streaming.generators;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PersonJsonGenerator {
    public static String generateJsonWithJsonGenerator(final JsonFactory jsonFactory, final ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        final JsonGenerator jsonGenerator = jsonFactory.createGenerator(byteArrayOutputStream, JsonEncoding.UTF8);
        jsonGenerator.useDefaultPrettyPrinter();
        // Start writing the JSON document
        jsonGenerator.writeStartObject();

        // Add a simple key-value pair
        jsonGenerator.writeStringField("firstName", "John");
        jsonGenerator.writeStringField("lastName", "Smith");

        // Add an array of numbers
        jsonGenerator.writeFieldName("aliases");
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString("Johnny S");
        jsonGenerator.writeString("Mavercik");
        jsonGenerator.writeString("Sparky");
        jsonGenerator.writeEndArray();

        jsonGenerator.writeFieldName("favoriteNumbers");
        jsonGenerator.writeStartArray();
        jsonGenerator.writeNumber(13);
        jsonGenerator.writeNumber(97);
        jsonGenerator.writeEndArray();

        // Add a nested object
        jsonGenerator.writeObjectFieldStart("address");
        jsonGenerator.writeStringField("street", "123 Main St");
        jsonGenerator.writeStringField("city", "Cityville");
        jsonGenerator.writeNumberField("zipCode", 12345);
        jsonGenerator.writeEndObject();

        // End the JSON document
        jsonGenerator.writeEndObject();

        // Close the JsonGenerator
        jsonGenerator.close();

        return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
    }
}
