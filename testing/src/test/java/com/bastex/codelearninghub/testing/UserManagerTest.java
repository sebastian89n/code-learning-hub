package com.bastex.codelearninghub.testing;

import com.bastex.codelearninghub.testing.domain.User;
import com.bastex.codelearninghub.testing.exceptions.UserValidationException;
import com.bastex.codelearninghub.testing.services.AuditInMemoryService;
import com.bastex.codelearninghub.testing.services.UserInMemoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class UserManagerTest {
    private UserManager defaultUserManager;

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
        defaultUserManager = new UserManager(new UserInMemoryService(), new AuditInMemoryService());
        defaultUserManager.upsert(new User(1L, "john.smith@gmail.com", "John", "Smith"));
        defaultUserManager.upsert(new User(2L, "john.wick@gmail.com", "John", "Wick"));
        defaultUserManager.upsert(new User(3L, "arnold.gomez@gmail.com", "Arnold", "Gomez"));
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void down() {
        log.info("@AfterAll - executed after all test methods.");
    }

    @Test
    void addNewUser_UserIsNull_ShouldThrowUserValidationException() {
        Assertions.assertThrows(UserValidationException.class, () -> defaultUserManager.addNewUser(null));
    }

    @Test
    void addNewUser_UserIdIsProvided_ShouldThrowUserValidationException() {
        final User user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setEmail("smith@gamil.com");

        Assertions.assertThrows(UserValidationException.class, () -> defaultUserManager.addNewUser(user));
    }

    @Test
    void addNewUser_UserEmailIsNull_ShouldThrowUserValidationException() {
        final User user = new User();
        user.setId(null);
        user.setEmail(null);
        user.setFirstName("John");
        user.setLastName("Smith");

        Assertions.assertThrows(UserValidationException.class, () -> defaultUserManager.addNewUser(user));
    }

    @Test
    void addNewUser_UserEmailIsEmpty_ShouldThrowUserValidationException() {
        final User user = new User();
        user.setId(null);
        user.setEmail("");
        user.setFirstName("John");
        user.setLastName("Smith");

        Assertions.assertThrows(UserValidationException.class, () -> defaultUserManager.addNewUser(user));
    }

    @Test
    void addNewUser_UserEmailIsBlank_ShouldThrowUserValidationException() {
        final User user = new User();
        user.setId(null);
        user.setEmail("  ");
        user.setFirstName("John");
        user.setLastName("Smith");

        Assertions.assertThrows(UserValidationException.class, () -> defaultUserManager.addNewUser(user));
    }
}