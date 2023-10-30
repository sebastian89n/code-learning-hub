package com.bastex.codelearninghub.jakartaee.servlets.utils;

import com.bastex.codelearninghub.jakartaee.servlets.dto.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceReader {
    private static final Pattern PROPERTIES_FILE_DELIMITER = Pattern.compile("=");

    @SneakyThrows(IOException.class)
    public static Map<String, User> readUsersFromResource(@NonNull final String resourcePath) {
        if (resourcePath.isBlank()) {
            throw new IllegalArgumentException("Path to user file cannot be empty");
        }

        try (final InputStream userFileIs = ResourceReader.class.getClassLoader()
                .getResourceAsStream(resourcePath)) {

            if (userFileIs == null) {
                throw new IllegalArgumentException("Unable to load file " + resourcePath);
            }

            final String fileContent = new String(userFileIs.readAllBytes(), StandardCharsets.UTF_8);
            return fileContent.lines()
                    .map(ResourceReader::transformToUser)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toMap(User::username, Function.identity()));
        }
    }

    private static User transformToUser(final String line) {
        if (line != null && !line.isBlank()) {
            final String[] split = PROPERTIES_FILE_DELIMITER.split(line);
            if (lineContainsProperlyDefinedUser(split)) {
                final String username = split[0].strip();
                final String password = split[1].strip();
                return new User(username, password);
            }
        }
        return null;
    }

    private static boolean lineContainsProperlyDefinedUser(final String[] split) {
        return split.length == 2 && !split[0].isBlank() && !split[1].isBlank();
    }
}
