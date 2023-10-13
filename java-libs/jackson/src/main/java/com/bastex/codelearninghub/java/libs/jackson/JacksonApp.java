package com.bastex.codelearninghub.java.libs.jackson;

import com.bastex.codelearninghub.java.libs.jackson.dto.Action;
import com.bastex.codelearninghub.java.libs.jackson.dto.Book;
import com.bastex.codelearninghub.java.libs.jackson.utils.ObjectMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class JacksonApp {
    public static void main(final String[] args) throws JsonProcessingException {
        final ObjectMapper objectMapper = ObjectMapperFactory.createJsonObjectMapper();
        final Book book = prepareDummyBook();

        final String jsonAsString = objectMapper.writeValueAsString(book);
        log.info("Parsed json: {}", jsonAsString);

        final Book parsedBook = objectMapper.readValue(jsonAsString, Book.class);
        log.info("Book: {}", parsedBook);

        final String jsonString = """
                {
                    "ideName": "IntelliJ IDEA",
                    "company": "Jetbrains"
                }
                """;
        // parse json to JsonNode
        final JsonNode jsonNode = objectMapper.readTree(jsonString);

        // Add field to the JsonNode
        ((ObjectNode) jsonNode).put("version", "2023.2.3 (Ultimate Edition)");
        log.info("JsonNode: {}", jsonNode);

        // Parse objects to correct implementations using @JsonSubTypes mapping
        final List<Action> actions = objectMapper.readValue(prepareActionsJson(), new TypeReference<>() {
        });
        log.info("Actions:\n{}", actions.stream()
                .map(Action::toString)
                .collect(Collectors.joining("\n")));

        // Test ObjectMapper for Xml - other types can be configured by providing dependencies to yaml, csv etc.
        final ObjectMapper xmlMapper = ObjectMapperFactory.createXmlObjectMapper();
        final String bookAsXml = xmlMapper.writeValueAsString(book);
        log.info("Book as xml: {}", bookAsXml);
    }

    private static Book prepareDummyBook() {
        final Book book = new Book();
        book.setId(1L);
        book.setName("Algorithms, 4th Edition");
        book.setIsbn("032157351X");
        book.setPublicationTime(Instant.now());
        book.setDetails("{\"summary\": \"Very good introduction for Algorithms. Examples based on Java.\"}");
        book.setSystemId("555");
        book.setAuthors(Set.of("Sedgewick Robert", "Wayne Kevin"));
        return book;
    }

    private static String prepareActionsJson() {
        return """
                [
                {
                	"type": "addLast",
                	"value": "last"
                },
                {
                	"type": "addFirst",
                	"value": "first"
                },
                {
                	"type": "addAt",
                	"position": 1,
                	"value": "at"
                },
                {
                	"type": "removeFrom",
                	"position": 2
                },
                {
                	"type": "set",
                	"position": 1,
                	"value": "at-updated"
                }
                ]""";
    }
}
