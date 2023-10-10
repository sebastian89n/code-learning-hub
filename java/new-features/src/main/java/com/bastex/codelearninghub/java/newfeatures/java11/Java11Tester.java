package com.bastex.codelearninghub.java.newfeatures.java11;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class Java11Tester {
    @SneakyThrows
    public static void testJava11Features() {
        // The most notable changes involved the addition of HTTPClient, Flight Recorder, an experimental low-pause garbage collector(ZGC),
        // and an experimental no-op garbage collector(Epsilon). Additionally, Java EE and CORBA modules got removed, and Nashorn deprecated.
        final String text = "  ";

        // new isBlank() method in String
        if (text.isBlank()) {
            log.info("Text is empty");
        }

        final String textWithSeparators = "Line 1\nLine 2\nLine 3";
        // new lines() method in String
        final List<String> lines = textWithSeparators.lines().toList();
        log.info("Lines: {}", lines.size());

        final String helloStr = "Hello!";
        // new repeat() method in String
        final String repeatHelloStr = helloStr.repeat(3);
        log.info(repeatHelloStr);

        // new strip() methods - differences between trim is that strip is unicode aware and removes all unicode whitespaces
        final String textWithEmptySpaces = "  Text   ";
        log.info(textWithEmptySpaces.strip());
        log.info(textWithEmptySpaces.stripLeading());
        log.info(textWithEmptySpaces.stripTrailing());
        log.info(textWithEmptySpaces.stripIndent());

        // new isEmpty() method on Optional
        if (getEmptyOptional().isEmpty()) {
            log.info("empty optional");
        }

        // new HttpClient
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .header("key1", "value1")
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
//                .POST(HttpRequest.BodyPublishers
//                        .ofInputStream(() -> new ByteArrayInputStream(sampleData)))
//                .POST(HttpRequest.BodyPublishers.ofByteArray(sampleData))
//                .POST(HttpRequest.BodyPublishers.fromFile(
//                        Paths.get("src/test/resources/sample.txt")))
                .build();

        try (final HttpClient httpClient = HttpClient.newBuilder().build()) {
            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(response.body());
        }
    }

    private static Optional<String> getEmptyOptional() {
        return Optional.empty();
    }
}
