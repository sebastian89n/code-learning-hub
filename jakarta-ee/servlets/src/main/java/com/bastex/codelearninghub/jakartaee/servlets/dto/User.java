package com.bastex.codelearninghub.jakartaee.servlets.dto;

public record User(String username, String password) {
    public static final String USER_SESSION_KEY = "user";
}
