package com.bastex.codelearninghub.java.libs.picocli.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.nio.file.Path;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestPreparator {
    @SneakyThrows(URISyntaxException.class)
    public static HttpRequest prepareUuidRequest() {
        return HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://httpbin.org/uuid"))
                .header("Accept", "application/json")
                .build();
    }

    @SneakyThrows(URISyntaxException.class)
    public static HttpRequest prepareDelayRequest(final int delay) {
        return HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://httpbin.org/delay/" + delay))
                .header("Accept", "application/json")
                .build();
    }

    @SneakyThrows({URISyntaxException.class, IOException.class})
    public static HttpRequest prepareAnythingRequest(final String payload, final Path payloadPath) {
        final HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(new URI("https://httpbin.org/anything"))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");

        if (payload != null && !payload.isBlank()) {
            requestBuilder.POST(HttpRequest.BodyPublishers.ofString(payload));
        } else if (payloadPath != null && Files.exists(payloadPath)) {
            requestBuilder.POST(HttpRequest.BodyPublishers.ofFile(payloadPath));
        }

        return requestBuilder.build();
    }
}
