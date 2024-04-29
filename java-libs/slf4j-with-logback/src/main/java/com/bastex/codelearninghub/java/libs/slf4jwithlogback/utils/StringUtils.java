package com.bastex.codelearninghub.java.libs.slf4jwithlogback.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class StringUtils {
    public static boolean isEmpty(final String text) {
        log.info("This message will be displayed because utils package default log level is INFO");
        log.debug("This message won't be displayed by default. Text value: {}", text);
        return text == null || text.isEmpty();
    }
}
