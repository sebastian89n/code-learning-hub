package com.bastex.codelearninghub.java.libs.junitwithmockito;

import com.bastex.codelearninghub.java.libs.junitwithmockito.domain.User;
import com.bastex.codelearninghub.java.libs.junitwithmockito.exceptions.UserValidationException;
import com.bastex.codelearninghub.java.libs.junitwithmockito.services.AuditInMemoryService;
import com.bastex.codelearninghub.java.libs.junitwithmockito.services.UserInMemoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Slf4j
class UserManagerJUnitTest {
    private static final long NOT_EXISTING_USER_ID = 999_999_999L;

    private UserManager defaultUserManager;

    @BeforeAll
    static void beforeAll() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void beforeEach() {
        log.info("@BeforeEach - executes before each test method in this class");
        defaultUserManager = new UserManager(new UserInMemoryService(), new AuditInMemoryService());
        defaultUserManager.upsert(new User(1L, "john.smith@gmail.com", "John", "Smith"));
        defaultUserManager.upsert(new User(2L, "john.wick@gmail.com", "John", "Wick"));
        defaultUserManager.upsert(new User(3L, "arnold.gomez@gmail.com", "Arnold", "Gomez"));
    }

    @AfterEach
    void afterEach() {
        log.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void afterAll() {
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

    @Test
    void addNewUser_ValidNewUserIsProvided_ShouldSaveNewUser() {
        final User newUser = new User();
        newUser.setEmail("james.bond@gmail.com");
        newUser.setFirstName("James");
        newUser.setLastName("Bond");

        final User savedUser = defaultUserManager.addNewUser(newUser);
        Assertions.assertNotNull(savedUser.getId());

        final boolean exists = defaultUserManager.exists(savedUser.getId());
        Assertions.assertTrue(exists);
    }

    @Test
    void upsert_NewUserIsAdded_ShouldSuccessfullyAddNewUser() {
        final User newUser = new User();
        newUser.setEmail("james.bond@gmail.com");
        newUser.setFirstName("James");
        newUser.setLastName("Bond");

        final User addedUser = defaultUserManager.upsert(newUser);
        Assertions.assertNotNull(addedUser.getId());

        final boolean exists = defaultUserManager.exists(addedUser.getId());
        Assertions.assertTrue(exists);
    }

    @Test
    void upsert_UpdateExistingUser_UserShouldGetCorrectlyUpdated() {
        final long existingUserId = 1L;

        final boolean exists = defaultUserManager.exists(existingUserId);
        Assertions.assertTrue(exists);

        final User userToUpdate = new User();
        userToUpdate.setId(existingUserId);
        userToUpdate.setEmail("james.bond@gmail.com");
        userToUpdate.setFirstName("James");
        userToUpdate.setLastName("Bond");

        defaultUserManager.upsert(userToUpdate);

        final Optional<User> userById = defaultUserManager.findUserById(existingUserId);
        Assertions.assertTrue(userById.isPresent());

        final User updatedUserAfterSaving = userById.get();

        // Execute always all assertions, even if preceding assertions fail
        Assertions.assertAll("Not all fields have been update",
                () -> Assertions.assertEquals(userToUpdate.getId(), updatedUserAfterSaving.getId()),
                () -> Assertions.assertEquals(userToUpdate.getEmail(), updatedUserAfterSaving.getEmail()),
                () -> Assertions.assertEquals(userToUpdate.getFirstName(), updatedUserAfterSaving.getFirstName()),
                () -> Assertions.assertEquals(userToUpdate.getLastName(), updatedUserAfterSaving.getLastName())
        );
    }

    @Test
    void deleteUserById_UserDoesNotExists_ShouldReturnFalse() {
        final boolean deleted = defaultUserManager.deleteUserById(NOT_EXISTING_USER_ID);
        Assertions.assertFalse(deleted);
    }

    @Test
    void deleteUserById_UserExists_ShouldReturnTrue() {
        final long userId = 1L;

        final Optional<User> existingUserById = defaultUserManager.findUserById(userId);
        Assertions.assertTrue(existingUserById.isPresent());

        final boolean deleted = defaultUserManager.deleteUserById(userId);
        Assertions.assertTrue(deleted);

        final Optional<User> deletedUserById = defaultUserManager.findUserById(userId);
        Assertions.assertFalse(deletedUserById.isPresent());
    }

    @Test
    void findUserFullNameById_UserByIdNotPresent_ShouldReturnEmptyOptional() {
        final Optional<String> userFullNameById = defaultUserManager.findUserFullNameById(NOT_EXISTING_USER_ID);
        Assertions.assertTrue(userFullNameById.isEmpty());
    }

    @Test
    void findUserFullNameById_UserByIdExists_ShouldReturnCorrectString() {
        final Optional<String> userFullNameById = defaultUserManager.findUserFullNameById(1L);
        Assertions.assertTrue(userFullNameById.isPresent());

        final String fullName = userFullNameById.get();
        Assertions.assertNotNull(fullName);
        Assertions.assertEquals("John Smith", fullName);
    }

    @Test
    void exists_UserNotExist_ShouldReturnFalse() {
        final boolean exists = defaultUserManager.exists(NOT_EXISTING_USER_ID);
        Assertions.assertFalse(exists);
    }

    @Test
    void exists_UserExists_ShouldReturnTrue() {
        final boolean exists = defaultUserManager.exists(1L);
        Assertions.assertTrue(exists);
    }
}