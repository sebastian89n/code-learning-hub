package com.bastex.codelearninghub.java.libs.picocli.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.file.Files;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InputValidator {
    public static void validateInputsForDelayCall(final int delay) {
        if (delay < 0 || delay > 10) {
            throw new IllegalArgumentException("Delay value must be from 0 to 10");
        }
    }

    public static void validateInputsForAnythingCall(final String payload, final Path payloadPath) {
        final boolean notEmptyPayloadSpecified = payload != null && !payload.isBlank();
        final boolean payloadPathProvided = payloadPath != null && Files.exists(payloadPath);
        if (notEmptyPayloadSpecified && payloadPathProvided) {
            throw new IllegalArgumentException("You can specify payload manually or via file, but not both.");
        }

        if (payloadPath != null && !Files.exists(payloadPath)) {
            throw new IllegalArgumentException("Unable to find payload file in specified path");
        }
    }
}
