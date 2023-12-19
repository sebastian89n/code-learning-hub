package com.bastex.codelearninghub.jakartaee.jsonp;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;
import jakarta.json.JsonWriterFactory;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class JsonPApp {
    public static void main(final String[] args) {
        final JsonObject generatedJsonObject = createJsonObject();
        final String employeeJsonAsText = prettyPrintJsonObject(generatedJsonObject);
        log.info("Generated json:\n{}", employeeJsonAsText);

        readDOMUsingJsonReader(employeeJsonAsText);
        parseStreamingUsingJsonParser(employeeJsonAsText);
    }

    private static JsonObject createJsonObject() {
        final String[] skills = {"Java", "JavaScript", "HTML", "CSS"};

        // Create a JsonArrayBuilder for the array of strings
        final JsonArrayBuilder skillsArrayBuilder = Json.createArrayBuilder();
        for (final String skill : skills) {
            skillsArrayBuilder.add(skill);
        }

        return Json.createObjectBuilder()
                .add("active", true)
                .add("employeeId", 123)
                .add("fullName", "John Smith")
                .add("salary", 5000.00)
                .add("birthDate", LocalDate.of(1990, 5, 15).toString())
                .add("skills", skillsArrayBuilder)
                .build();
    }

    private static void readDOMUsingJsonReader(final String employeeJsonAsText) {
        try (final JsonReader jsonReader = Json.createReader(new StringReader(employeeJsonAsText))) {
            final JsonObject jsonObject = jsonReader.readObject();

            final boolean active = jsonObject.getBoolean("active");
            final int employeeId = jsonObject.getInt("employeeId");
            final String fullName = jsonObject.getString("fullName");
            final double salary = jsonObject.getJsonNumber("salary").doubleValue();
            final String birthDate = jsonObject.getString("birthDate");

            final List<String> skills = new ArrayList<>();
            final JsonArray skillsArray = jsonObject.getJsonArray("skills");
            for (int i = 0; i < skillsArray.size(); i++) {
                skills.add(skillsArray.getString(i));
            }

            // Display the parsed values
            log.info("--");
            log.info("Values parsed from JsonObject:");
            log.info("Active: {}", active);
            log.info("Employee ID: {}", employeeId);
            log.info("Full Name: {}", fullName);
            log.info("Salary: {}", salary);
            log.info("Birth Date: {}", birthDate);
            log.info("Skills: {}", skills);
        }
    }

    private static void parseStreamingUsingJsonParser(final String employeeJsonAsText) {
        log.info("--");
        log.info("Parsing json in a streaming fashion");
        try (final JsonParser jsonParser = Json.createParser(new StringReader(employeeJsonAsText))) {
            while (jsonParser.hasNext()) {
                final JsonParser.Event event = jsonParser.next();
                switch (event) {
                    case START_OBJECT -> log.info("Start of Object");
                    case END_OBJECT -> log.info("End of Object");
                    case START_ARRAY -> log.info("Start of Array");
                    case END_ARRAY -> log.info("End of Array");
                    case KEY_NAME -> {
                        final String key = jsonParser.getString();
                        log.info("Key: {}", key);
                    }
                    case VALUE_STRING -> {
                        final String valueString = jsonParser.getString();
                        log.info("String Value: {}", valueString);
                    }
                    case VALUE_NUMBER -> {
                        final String valueNumber = jsonParser.getBigDecimal().toString();
                        log.info("Number Value: {}", valueNumber);
                    }
                    case VALUE_TRUE -> log.info("Boolean Value: true");
                }
            }
        }
    }

    private static String prettyPrintJsonObject(final JsonObject jsonObject) {
        final StringWriter stringWriter = new StringWriter();

        final Map<String, Boolean> config = Map.of(JsonGenerator.PRETTY_PRINTING, true);
        final JsonWriterFactory writerFactory = Json.createWriterFactory(config);

        try (final JsonWriter jsonWriter = writerFactory.createWriter(stringWriter)) {
            jsonWriter.writeObject(jsonObject);
        }

        return stringWriter.toString();
    }
}
