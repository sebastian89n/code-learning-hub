package com.bastex.codelearninghub.java.libs.picocli;

import com.bastex.codelearninghub.java.libs.picocli.utils.InputValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import static picocli.CommandLine.Option;
import static picocli.CommandLine.Parameters;

@Slf4j
public class PicocliApp {
    public static void main(final String[] args) {
        final CommandLine commandLine = new CommandLine(new HttpBinConnector());
        final int exitCode = commandLine.execute(args);

        System.exit(exitCode);
    }

    static class HttpBinConnector implements Callable<Integer> {
        @Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
        private boolean helpRequested;

        @Option(names = {"-ct", "--call-type"}, arity = "1..3", description = "Call types to execute against httpbin.org. Available call types: ${COMPLETION-CANDIDATES}", required = true)
        private final Set<CallType> callTypes = new LinkedHashSet<>();

        @Option(names = {"-p", "--payload"}, description = "Payload as String, e.g. json")
        private String payload;

        @Option(names = {"-d", "--delay"}, description = "Delay duration in seconds. Min 0, Max 10")
        private int delay;

        @Parameters(paramLabel = "Payload files", description = "Path to json file with payload", arity = "0..1")
        private Path payloadPath;

        @Override
        public Integer call() {
            try (final HttpClient httpClient = HttpClient.newBuilder().build();) {
                for (final CallType callType : callTypes) {
                    validateInputs(callType);
                    final HttpRequest httpRequest = switch (callType) {
                        case UUID -> prepareUuidRequest();
                        case DELAY -> prepareDelayRequest(delay);
                        case ANYTHING -> prepareAnythingRequest(payload, payloadPath);
                    };

                    final HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    log.info("{}({}): \n{}", callType, response.statusCode(), response.body());
                }

            } catch (final Exception e) {
                log.error("Unable to execute program", e);
            }

            return 0;
        }

        @SneakyThrows(URISyntaxException.class)
        private HttpRequest prepareUuidRequest() {
            return HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("https://httpbin.org/uuid"))
                    .header("accept", "application/json")
                    .build();
        }

        @SneakyThrows(URISyntaxException.class)
        private HttpRequest prepareDelayRequest(final int delay) {
            return HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("https://httpbin.org/delay/" + delay))
                    .header("accept", "application/json")
                    .build();
        }

        @SneakyThrows({URISyntaxException.class, IOException.class})
        private HttpRequest prepareAnythingRequest(final String payload, final Path payloadPath) {
            final HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(new URI("https://httpbin.org/anything"))
                    .header("Content-Type", "application/json");

            if (payload != null && !payload.isBlank()) {
                requestBuilder.POST(HttpRequest.BodyPublishers.ofString(payload));
            } else if (payloadPath != null && Files.exists(payloadPath)) {
                requestBuilder.POST(HttpRequest.BodyPublishers.ofFile(payloadPath));
            }

            return requestBuilder.build();
        }

        private void validateInputs(final CallType callType) {
            switch (callType) {
                case UUID -> {
                }
                case DELAY -> InputValidator.validateInputsForDelayCall(delay);
                case ANYTHING -> InputValidator.validateInputsForAnythingCall(payload, payloadPath);
            }
        }
    }

    enum CallType {
        UUID,
        DELAY,
        ANYTHING
    }
}
