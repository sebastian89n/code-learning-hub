package com.bastex.codelearninghub.java.libs.jackson.databind.dto;

import com.bastex.codelearninghub.java.libs.jackson.databind.deserializers.BookDateDeserializer;
import com.bastex.codelearninghub.java.libs.jackson.databind.deserializers.CustomJsonToStringDeserializer;
import com.bastex.codelearninghub.java.libs.jackson.databind.serializers.BookDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

//@JsonPropertyOrder({"id", "isbn", "name", "authors"}) - specify order by names
@JsonRootName("book")
@Data
public class Book {
    @JsonProperty(value = "oid", index = 0) // specify custom field name and optionally index
    private Long id;

    private String name;

    private String isbn;

    @JsonSerialize(using = BookDateSerializer.class) // specify custom serializer
    @JsonDeserialize(using = BookDateDeserializer.class) // specify custom deserializer
    private Instant publicationTime;

    private Set<String> authors;

    @JsonRawValue // allows to serialize a text without escaping or without any decoration
    @JsonDeserialize(using = CustomJsonToStringDeserializer.class) // deserialize custom value to String
    private String details;

    @JsonIgnore // used at field level to mark a property or list of properties to be ignored
    private String systemId;
}
