package com.bastex.codelearninghub.java.libs.jackson.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class DateFormatUtils {
    private static final DateTimeFormatter STANDARD_DATE_OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
            .withZone(ZoneId.of("UTC"));

    public static String formatDate(@NonNull final Instant instant) {
        try {
            return STANDARD_DATE_OUTPUT_FORMAT.format(instant);
        } catch (final RuntimeException e) {
            log.error("Unable to format date " + instant, e);
            throw e;
        }
    }

    public static Instant parse(@NonNull final String dateTimeAsText) {
        try {
            return STANDARD_DATE_OUTPUT_FORMAT.parse(dateTimeAsText, Instant::from);
        } catch (final RuntimeException e) {
            log.error("Unable to parse date " + dateTimeAsText, dateTimeAsText);
            throw e;
        }
    }
}
