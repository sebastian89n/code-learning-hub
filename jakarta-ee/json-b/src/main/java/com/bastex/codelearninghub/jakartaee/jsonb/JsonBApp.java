package com.bastex.codelearninghub.jakartaee.jsonb;

import com.bastex.codelearninghub.jakartaee.jsonb.dto.Employee;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyNamingStrategy;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonBApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final String employeeJson = """
                {
                  "employeeId": 123,
                  "fullName": "John Smith",
                  "salary": 5000.00,
                  "birthDate": "1990-05-15",
                      "skills": [
                          "Java",
                          "JavaScript",
                          "HTML",
                          "CSS"
                      ]
                }
                """;

        final JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withNullValues(false)
                .withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

        try (final Jsonb jsonb = JsonbBuilder.create(config)) {
            final Employee employee = jsonb.fromJson(employeeJson, Employee.class);
            log.info("Employee: {}", employee);
        }
    }
}
