package com.bastex.codelearninghub.java.libs.jackson.streaming.parsers;

import com.bastex.codelearninghub.java.libs.jackson.streaming.dto.Person;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonJsonParser {
    public static Person parsePerson(final JsonFactory jsonFactory, final String jsonAsText) throws IOException {
        final JsonParser jsonParser = jsonFactory.createParser(jsonAsText);

        // Create a Person object to store the parsed data
        final Person person = new Person();

        // Parse the JSON using JsonParser
        while (jsonParser.nextToken() != null) {
            if (jsonParser.currentToken() == JsonToken.FIELD_NAME) {
                final String fieldName = jsonParser.getCurrentName();
                jsonParser.nextToken(); // Move to the value token

                switch (fieldName) {
                    case "firstName" -> person.setFirstName(jsonParser.getText());
                    case "lastName" -> person.setLastName(jsonParser.getText());
                    case "aliases" -> person.setAliases(parseStringArray(jsonParser));
                    case "favoriteNumbers" -> person.setFavoriteNumbers(parseIntegerArray(jsonParser));
                    case "address" -> person.setAddress(parseAddress(jsonParser));
                    default -> throw new IllegalStateException("Unhandled field name");
                }
            }
        }

        // Close the JsonParser
        jsonParser.close();
        return person;
    }

    private static List<String> parseStringArray(final JsonParser jsonParser) throws IOException {
        final List<String> stringList = new ArrayList<>();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            stringList.add(jsonParser.getText());
        }
        return stringList;
    }

    private static List<Integer> parseIntegerArray(final JsonParser jsonParser) throws IOException {
        final List<Integer> integerList = new ArrayList<>();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
            integerList.add(jsonParser.getIntValue());
        }
        return integerList;
    }

    private static Person.Address parseAddress(final JsonParser jsonParser) throws IOException {
        final Person.Address address = new Person.Address();
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            final String fieldName = jsonParser.getCurrentName();
            jsonParser.nextToken(); // Move to the value token

            switch (fieldName) {
                case "street" -> address.setStreet(jsonParser.getText());
                case "city" -> address.setCity(jsonParser.getText());
                case "zipCode" -> address.setZipCode(jsonParser.getIntValue());
                default -> throw new IllegalStateException("Unhandled field name");
            }
        }
        return address;
    }
}
