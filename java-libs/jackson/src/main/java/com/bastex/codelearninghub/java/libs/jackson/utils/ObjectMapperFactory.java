package com.bastex.codelearninghub.java.libs.jackson.utils;

import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObjectMapperFactory {
    public static ObjectMapper createJsonObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();

        // Setting some custom properties
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Setting stream read constraints
        final StreamReadConstraints streamReadConstraints = prepareStreamReadConstraints();
        objectMapper.getFactory().setStreamReadConstraints(streamReadConstraints);
        return objectMapper;
    }

    public static ObjectMapper createXmlObjectMapper() {
        return new XmlMapper(); // or new ObjectMapper(new XmlFactory()) - different factories for different types
    }


    private static StreamReadConstraints prepareStreamReadConstraints() {
        return StreamReadConstraints.builder()
                .maxStringLength(10_000_000)
                .maxNestingDepth(100)
                .maxNumberLength(100)
                .build();
    }
}
