# slf4j-with-logback

The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g.
java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

Appender defines output place of the logs.

Log levels: ERROR < WARN < INFO < DEBUG < TRACE

#### Pattern layout configuration:

**%d{HH:mm:ss.SSS}** – a timestamp with hours, minutes, seconds and milliseconds

**[%thread]** – the thread name generating the log message, surrounded by square brackets

**%-5level** – the level of the logging event, padded to 5 characters

**%logger{36}** – the name of the logger, truncated to 35 characters

**%msg%n** – the log messages followed by the platform dependent line separator character

**More info in the comments in logback.xml**