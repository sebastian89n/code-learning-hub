# Picocli

Picocli is a powerful Java library for creating command-line applications with ease. It simplifies the development of
command-line interfaces (CLIs) by providing an intuitive and declarative approach to parsing command-line arguments and
options. Picocli is widely used in Java applications to create user-friendly, structured CLIs.

Code example is an application that runs REST queries against httpbin.org

e.g. program arguments to run

`--call-type=UUID`

`--call-type=DELAY --delay=1`

`--call-type=ANYTHING --delay=1 --payload="{'text': 'value'}"`

Picocli offers a wide range of features and annotations to simplify the process of building command-line applications.

### Annotations

- **`@Command`:** The `@Command` annotation is used to define the top-level command, encapsulating the application
  logic. It specifies the command name, version, and description, among other attributes.

- **`@Option`:** The `@Option` annotation marks a field or method as a command-line option. It provides parameters to
  configure the option, such as the option name, description, and default values.

- **`@Parameters`:** The `@Parameters` annotation is used to define command-line parameters (non-option arguments) and
  provides similar configurability to `@Option`.

- **`@Mixin`:** Mixins allow you to reuse sets of options and parameters across multiple commands, promoting code
  reusability and consistency.

- **`@Spec`:** The `@Spec` annotation provides access to the `CommandLine` object, enabling programmatic manipulation of
  command-line arguments and options.

### Nested Commands

- Picocli supports the creation of nested commands and subcommands using the `@Command` annotation. This enables the
  creation of hierarchical CLIs with structured menus and options.

### Type Conversion

- Picocli offers automatic type conversion for command-line arguments and options, reducing the need for manual parsing
  and validation.

### Help Generation

- Picocli can generate user-friendly help messages, including usage information, descriptions of commands, and
  explanations of options.

### Customization

- Picocli allows customization of the help messages, allowing you to tailor the output to your application's needs.

### Annotation-Based Configuration

- The library is configured primarily through annotations, simplifying the development of CLIs and promoting clean code.

Picocli is a versatile and user-friendly library that helps developers create robust command-line applications in Java.
It is often used for command-line tools, scripting, and automation tasks.