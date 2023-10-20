package com.bastex.codelearninghub.java.libs.junitwithmockito;

import com.bastex.codelearninghub.java.libs.junitwithmockito.domain.User;
import com.bastex.codelearninghub.java.libs.junitwithmockito.services.AuditService;
import com.bastex.codelearninghub.java.libs.junitwithmockito.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@Slf4j
class UserManagerJUnitWithMockitoTest {
    private static final long USER_ID = 10L;

    @Mock
    private AuditService auditServiceMock;

    @Mock
    private UserService userServiceMock;

    private UserManager userManager;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void beforeEach() {
        // Initializes mock for objects annotated with @Mock annotation
        autoCloseable = MockitoAnnotations.openMocks(this);
        userManager = new UserManager(userServiceMock, auditServiceMock);
    }

    @AfterEach
    void afterEach() throws Exception {
        autoCloseable.close();
    }

    @Test
    void addNewUser_NewUserIsAdded_MakeSureAuditMethodIsCalled() {
        final User newUser = new User();
        newUser.setEmail("james.bond@gmail.com");
        newUser.setFirstName("James");
        newUser.setLastName("Bond");

        final User savedUser = new User();
        savedUser.setId(USER_ID);
        savedUser.setEmail("james.bond@gmail.com");
        savedUser.setFirstName("James");
        savedUser.setLastName("Bond");

        // mocks save method in userServiceMock to return specific result for specific input
        Mockito.when(userServiceMock.save(newUser)).thenReturn(savedUser);

        userManager.addNewUser(newUser);

        // verify that audit method was called once
        Mockito.verify(auditServiceMock, Mockito.times(1))
                .addSaveNewEntryEvent(Mockito.eq(USER_ID));
    }

    @Test
    void upsert_NewUserAdded_ShouldCallCorrectAuditMethod() {
        // Example of initializing mocks inline without @Mock annotation etc.
        final UserService userServiceInlineMock = Mockito.mock(UserService.class);
        final AuditService auditServiceInlineMock = Mockito.mock(AuditService.class);
        final UserManager userManagerInline = new UserManager(userServiceInlineMock, auditServiceInlineMock);


        final User newUser = new User();
        newUser.setEmail("james.bond@gmail.com");
        newUser.setFirstName("James");
        newUser.setLastName("Bond");

        final User savedUser = new User();
        savedUser.setId(USER_ID);
        savedUser.setEmail("james.bond@gmail.com");
        savedUser.setFirstName("James");
        savedUser.setLastName("Bond");

        Mockito.when(userServiceInlineMock.save(newUser)).thenReturn(savedUser);
        userManagerInline.upsert(newUser);

        // Mockito.eq -> Matcher on values passed in the method
        Mockito.verify(auditServiceInlineMock, Mockito.times(1))
                .addSaveNewEntryEvent(Mockito.eq(USER_ID));
        Mockito.verify(auditServiceInlineMock, Mockito.never()).addUpdateNewEntryEvent(Mockito.anyLong());
    }

    @Test
    void upsert_ExistingUserUpdated_ShouldCallCorrectAuditMethod() {
        final User existingUser = new User();
        existingUser.setId(USER_ID);
        existingUser.setEmail("james.bond@gmail.com");
        existingUser.setFirstName("James");
        existingUser.setLastName("Bond");

        // mock implementation of save method
        Mockito.when(userServiceMock.save(existingUser)).thenReturn(existingUser);

        userManager.upsert(existingUser);

        Mockito.verify(auditServiceMock, Mockito.times(1))
                .addUpdateNewEntryEvent(Mockito.eq(USER_ID));
        Mockito.verify(auditServiceMock, Mockito.never())
                .addSaveNewEntryEvent(Mockito.anyLong());
    }

    @Test
    void deleteUserById_UserIsDeleted_MakeSureAuditMethodIsCalled() {
        Mockito.when(userServiceMock.deleteById(USER_ID)).thenReturn(true);

        userManager.deleteUserById(USER_ID);

        // Verify method is called only once
        Mockito.verify(auditServiceMock, Mockito.times(1))
                .addNewDeletedEvent(USER_ID);
    }

    @Test
    void deleteUserById_UserIsNotDeleted_MakeSureAuditMethodIsNotCalled() {
        // mock implementation of save method
        Mockito.when(userServiceMock.deleteById(USER_ID)).thenReturn(false);

        userManager.deleteUserById(USER_ID);

        // verify that audit method was not called. Mockito.anyLong() matches on any long passed in that method execution
        Mockito.verify(auditServiceMock, Mockito.never()).addNewDeletedEvent(Mockito.anyLong());
    }
}
