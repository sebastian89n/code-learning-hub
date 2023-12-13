package com.bastex.codelearninghub.java.libs.jackson.streaming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstName;

    private String lastName;

    private List<String> aliases;

    private List<Integer> favoriteNumbers;

    private Address address;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String street;

        private String city;

        private int zipCode;
    }
}
