# SLF4J (Simple Logging Facade for Java) and Logback

SLF4J (Simple Logging Facade for Java) and Logback are popular Java libraries used for logging and managing log output
in Java applications. SLF4J serves as a facade, providing a simple and consistent logging API, while Logback is one of
the implementations of this API. Together, they offer a powerful, flexible, and efficient solution for logging in Java
applications.

## SLF4J: Simple Logging Facade for Java

SLF4J is a logging facade designed to provide a common, straightforward API for various logging frameworks. It serves as
a bridge between your application code and the actual logging implementation, allowing developers to write log
statements using SLF4J's API. Key features and concepts include:

### Logger Initialization

- SLF4J is typically initialized by obtaining a logger instance using the `LoggerFactory.getLogger()` method. Logger
  names are often based on the fully qualified class name to provide context. This is even further simplified when using
  Lombok library that generates logger automatically with `@Slf4j` annotation.

### Log Levels

- SLF4J supports log levels such as `TRACE`, `DEBUG`, `INFO`, `WARN`, and `ERROR`. Log statements are typically logged
  at different levels depending on the severity of the message.

### Parameterized Logging

- SLF4J supports parameterized logging, allowing you to include variables or values in log messages efficiently.

## Logback: Logging Implementation

Logback is an open-source logging framework that provides an SLF4J implementation. It is widely used for logging in Java
applications and offers several notable features:

### Logging Configuration

- Logback supports flexible and versatile configuration using XML or Groovy configuration files. This allows developers
  to customize log output, log file rotation, and more.

### Appender System

- Logback employs an appender system, allowing you to specify where log messages should be written. Appenders can send
  log messages to various destinations, including files, the console, and remote servers.

### Rolling File Appenders

- Logback includes built-in support for rolling file appenders, enabling log file rotation based on size or time. This
  is crucial for managing log files in production environments.

### Filtering and TurboFilters

- Logback supports filtering capabilities to control which log messages are processed and sent to appenders.
  TurboFilters allow you to write custom filtering logic.

### Layouts

- Logback includes layout support to control the format of log messages, making it easy to customize the appearance of
  log entries.

### Pattern layout configuration:

**%d{HH:mm:ss.SSS}** – a timestamp with hours, minutes, seconds and milliseconds

**[%thread]** – the thread name generating the log message, surrounded by square brackets

**%-5level** – the level of the logging event, padded to 5 characters

**%logger{36}** – the name of the logger, truncated to 35 characters

**%msg%n** – the log messages followed by the platform dependent line separator character

**More information can be found in the comments in logback.xml file**
