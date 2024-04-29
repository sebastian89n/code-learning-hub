package com.bastex.codelearninghub.java.libs.slf4jwithlogback;

import com.bastex.codelearninghub.java.libs.slf4jwithlogback.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Slf4jWithLogbackApp {
    public static void main(final String[] args) {
        log.info("Default root log level is WARN so this message won't be displayed");
        log.warn("This message will be displayed");

        if (StringUtils.isEmpty(null)) {
            log.error("This message will be displayed. Text value is null or empty");
        }
    }
}
