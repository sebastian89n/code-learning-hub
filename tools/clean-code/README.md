# Clean Code

**Clean Code by Robert C. Martin** is a book that provides principles and practices for writing readable, maintainable,
and
high-quality code. It promotes the idea that well-written code is like a well-written piece of literature, easy to
understand and elegant in its simplicity. Here are some key takeaways:

## Meaningful Names

- Choose descriptive and meaningful names for variables, functions, and classes. Names should reveal the intent and
  purpose of the code.

**Example in Java:**

```java
// Bad naming
int d; // Avoid using single-letter variable names.
        String x; // Avoid generic names that don't convey meaning.

// Good naming
        int numberOfDays; // Descriptive name for a variable.
        String customerName; // Meaningful name for a string variable.
```

## Functions

- Keep functions short and focused, ideally no more than a few lines. Functions should have a single responsibility and
  do one thing well. Use meaningful names for functions that reflect their purpose.

**Bad example:**

```java
// Bad function with multiple responsibilities
public void processOrderAndSendEmail(Order order){
        // Process the order
        // ...

        // Send an email to the customer
        // ...
        }
```

In the bad example, the function processOrderAndSendEmail has multiple responsibilities. It both processes an order and
sends an email, violating the principle of having a single responsibility for a function.

**Good example:**

```java
// Good functions with single responsibilities
public void processOrder(Order order){
        // Process the order
        // ...
        }

public void sendOrderConfirmationEmail(Order order){
        // Send an email to the customer
        // ...
        }
```

In the good example, the responsibilities have been separated into two functions, processOrder and
sendOrderConfirmationEmail, each with a single, well-defined responsibility. This makes the code more readable and
maintainable.

## Comments

- Strive to write self-explanatory code without the need for excessive comments. If comments are necessary, make sure
  they explain "why" and not just "what."

## Formatting

- Consistently format your code to make it visually appealing. Use indentation, spacing, and consistent style
  guidelines.

## Error Handling

- Handle errors gracefully and avoid using exceptions for control flow. Use error codes, return values, or custom error
  objects where appropriate.

## DRY (Don't Repeat Yourself)

- Avoid code duplication by encapsulating common functionality in functions or classes.

## Testing

- Write tests to ensure code correctness and maintainability. Follow the "Arrange, Act, Assert" pattern for writing test
  cases.

## SOLID Principles

The SOLID principles are a set of guidelines for designing and maintaining software that promotes clean, maintainable,
and extensible code. Each principle focuses on a specific aspect of object-oriented design.

### Single Responsibility Principle (SRP)

- A class should have only one reason to change. It should have a single responsibility, meaning it should do one thing
  and do it well.
- This principle encourages modular design and reduces the potential for unintended side effects when making changes.

### Open-Closed Principle (OCP)

- Software entities (classes, modules, functions) should be open for extension but closed for modification.
- This principle promotes the idea of extending functionality through new code rather than altering existing code.

### Liskov Substitution Principle (LSP)

- Subtypes must be substitutable for their base types without altering the correctness of the program.
- Inheritance should not introduce behavior that contradicts the behavior of the base class.

### Interface Segregation Principle (ISP)

- Clients should not be forced to depend on interfaces they don't use.
- It's better to have multiple, smaller interfaces that cater to specific client needs, rather than a monolithic one.

### Dependency Inversion Principle (DIP)

- High-level modules should not depend on low-level modules. Both should depend on abstractions.
- Abstractions should not depend on details. Details should depend on abstractions.

These SOLID principles provide a foundation for creating code that is modular, extensible, and easy to maintain,
ensuring your software remains adaptable to changing requirements and less prone to bugs.

## Code Smells

- Be aware of common code smells like long functions, large classes, and inconsistent naming. Refactor code to eliminate
  these smells and improve code quality.

## Collaborative Coding

- Work collaboratively and engage in code reviews to improve code quality. Use version control systems for tracking
  changes and collaborating with others.

## Continuous Improvement

- Strive for continuous improvement in your code and coding practices. Keep learning and adapting to new techniques and
  best practices.