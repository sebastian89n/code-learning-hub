package com.bastex.codelearninghub.java.libs.jackson.streaming;

import com.bastex.codelearninghub.java.libs.jackson.streaming.dto.Person;
import com.bastex.codelearninghub.java.libs.jackson.streaming.generators.PersonJsonGenerator;
import com.bastex.codelearninghub.java.libs.jackson.streaming.parsers.PersonJsonParser;
import com.fasterxml.jackson.core.JsonFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
public class JacksonStreamingApp {
    @SneakyThrows(IOException.class)
    public static void main(final String[] args) {
        try (final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            final JsonFactory jsonFactory = new JsonFactory();

            final String jsonAsText = PersonJsonGenerator.generateJsonWithJsonGenerator(jsonFactory, byteArrayOutputStream);
            log.info("Generated json:\n{}", jsonAsText);

            final Person person = PersonJsonParser.parsePerson(jsonFactory, jsonAsText);
            log.info("Parsed person:\n{}", person);
        }
    }
}
