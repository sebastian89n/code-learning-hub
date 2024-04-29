# JUnit 5

JUnit 5 is a modern Java testing framework that provides an efficient and feature-rich platform for creating and running
unit tests. It offers a standardized way to ensure the correctness and reliability of Java code. Additionally, it
simplifies test creation, organization, and execution. JUnit 5 is a popular choice for Java developers, supporting
test-driven development (TDD) and ensuring code quality.

JUnit 5 introduces new features and improvements over JUnit 4, offering a more flexible and extensible testing
framework.

### Annotations

- Test methods are annotated with `@Test`, indicating that they are test cases.
- JUnit 5 provides various annotations, such as `@BeforeAll`, `@AfterAll`, `@BeforeEach`, and `@AfterEach`, for setup
  and teardown actions at both the class and method levels.
- `@DisplayName` allows custom naming of test cases for better readability.

### Nested Tests

- JUnit 5 allows the creation of nested test classes, improving test organization and reducing code duplication.
- Nested tests are annotated with `@Nested` and can contain their own lifecycle methods and assertions.

### Parameterized Tests

- `@ParameterizedTest` simplifies the creation of parameterized tests, enabling one test method to be executed multiple
  times with different arguments.
- `@MethodSource` and other parameter sources facilitate data-driven testing.

### Dynamic Tests

- Dynamic tests can be generated at runtime using the `@TestFactory` annotation, allowing for more complex and flexible
  test scenarios.

### Extensions

- JUnit 5 introduces a powerful extension model that supports custom extensions, such as mocking frameworks like Mockito
  or custom test behavior.
- Extensions can be registered using `@ExtendWith` to enhance test capabilities.

### Conditional Test Execution

- `@EnabledOnOs`, `@DisabledOnJre`, and other conditional annotations control when tests are executed.
- Custom conditions can also be implemented for fine-grained test control.

# Mockito: Mocking Framework for Testing

Mockito is a Java mocking framework commonly used alongside JUnit 5 for creating and managing mock objects in unit
tests. Mock objects simulate the behavior of real objects, helping to isolate the code under test. Mockito provides a
straightforward way to create, configure, and verify interactions with mock objects during unit testing.

### Mocking

- The `@Mock` annotation is used to create mock objects for classes or interfaces.
- Mock objects are initialized using `MockitoAnnotations.openMocks(this)` in the `@BeforeEach` setup method.

### Stubbing

- Use `when(mockObject.methodCall()).thenReturn(expectedResult)` to define the behavior of mock objects.
- Stubbing allows you to specify expected return values or exceptions.

### Verification

- `verify(mockObject).methodCall()` is used to verify that a specific method was called on a mock object.
- Mockito provides various verification methods to check the number of invocations and order of method calls.

### Argument Matchers

- Matchers like `any()`, `eq(value)`, and others are used to match method arguments during verification and stubbing.
- Argument matchers help define flexible expectations for method calls.

### Spying

- Mockito's `@Spy` annotation allows you to create a partial mock of a real object, enabling you to verify and stub
  specific methods while preserving the original behavior for others.

Mockito, when used in conjunction with JUnit 5, allows you to simulate the behavior of dependencies, enabling isolated
testing of individual components within a Java application.