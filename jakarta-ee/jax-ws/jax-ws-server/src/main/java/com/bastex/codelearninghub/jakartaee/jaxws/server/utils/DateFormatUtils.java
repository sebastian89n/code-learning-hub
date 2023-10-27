package com.bastex.codelearninghub.jakartaee.jaxws.server.utils;

import lombok.NonNull;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatUtils {
    private static final DateTimeFormatter STANDARD_DATE_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
            .withZone(ZoneId.of("UTC"));

    public static String formatDate(@NonNull final Instant instant) {
        return STANDARD_DATE_OUTPUT_FORMAT.format(instant);
    }
}
