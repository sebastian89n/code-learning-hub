package com.bastex.codelearninghub.jakartaee.jsonb;

import com.bastex.codelearninghub.jakartaee.jsonb.dto.Employee;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class JsonBApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final String employeeJson = """
                {
                  "employeeId": 123,
                  "fullName": "John Smith",
                   "address": null,
                  "salary": 5000.00,
                  "birthDate": "1990-05-15",
                      "skills": [
                          "Java",
                          "JavaScript",
                          "HTML",
                          "CSS"
                      ],
                  "certificationDate": "2022-04-01T15:30:00Z"
                }
                """;

        final JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withNullValues(false);

        try (final Jsonb jsonb = JsonbBuilder.create(config)) {
            final Employee employee = jsonb.fromJson(employeeJson, Employee.class);
            log.info("Employee: {}", employee);
            employee.setLastLogin(Instant.now());
            final String json = jsonb.toJson(employee);
            log.info("Json string: {}", json);
        }
    }
}
