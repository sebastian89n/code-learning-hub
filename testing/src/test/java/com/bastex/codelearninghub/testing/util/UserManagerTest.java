package com.bastex.codelearninghub.testing.util;

import com.bastex.codelearninghub.testing.UserManager;
import com.bastex.codelearninghub.testing.services.UserMapService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
class UserManagerTest {
    private UserManager userManager;

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
        userManager = new UserManager(new UserMapService());
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void down() {
        log.info("@AfterAll - executed after all test methods.");
    }
}