# Jakarta JSON Processing

## Overview

Jakarta JSON Processing (JSON-P) is a Java API for processing JSON (JavaScript Object Notation) data. It provides a
versatile set of tools for working with JSON, including reading and writing JSON data, navigating JSON structures, and
manipulating JSON objects.

JSON-P is a crucial component of the Jakarta EE platform, enabling Java developers to seamlessly integrate JSON
processing capabilities into their applications. It simplifies tasks such as creating JSON data, parsing JSON strings,
and interacting with JSON objects and arrays.

## Key Features

- **JSON Object Model:** JSON-P provides a comprehensive object model for representing JSON data in Java. Developers can
  easily create, manipulate, and navigate JSON objects and arrays.

- **Streaming API:** JSON-P includes a streaming API that allows for efficient processing of large JSON documents. This
  is particularly useful for scenarios where memory efficiency is critical.

- **DOM API:** The Document Object Model (DOM) API in JSON-P enables the creation of an in-memory representation of a
  complete JSON document. This model is convenient for working with smaller JSON datasets.

- **Builder API:** JSON-P supports a builder pattern for creating JSON objects and arrays in a fluent and expressive
  manner, making it easy to construct complex JSON structures.

- **Integration with Other Jakarta EE Technologies:** JSON-P seamlessly integrates with other Jakarta EE technologies,
  facilitating the exchange of JSON data between components in a Jakarta EE application.

## JSON-P API Reference

1. **Json**
    - *Description:* The main entry point for working with Jakarta JSON-P. It provides factory methods for creating JSON
      objects, arrays, and readers/writers.

2. **JsonObject**
    - *Description:* Represents a JSON object. It provides methods for accessing and manipulating the key-value pairs
      within
      the object.

3. **JsonArray**
    - *Description:* Represents a JSON array. It provides methods for accessing and manipulating the elements within the
      array.

4. **JsonObjectBuilder**
    - *Description:* A builder for creating JSON objects in a fluent style.

5. **JsonArrayBuilder**
    - *Description:* A builder for creating JSON arrays in a fluent style.

6. **JsonReader**
    - *Description:* Reads and parses JSON data in a DOM (Document Object Model) approach. It reads the entire JSON data
      and builds an in-memory representation of the complete JSON structure. This approach is suitable when you need to
      work
      with the complete JSON structure.

7. **JsonParser**
    - *Description:* Parses JSON data in a streaming fashion. It processes the JSON data token by token, allowing for
      low-level, event-driven parsing. This approach is suitable when you want to process large JSON documents
      efficiently
      without loading the entire structure into memory.

8. **JsonPointer**
    - *Description:* Represents a JSON Pointer, which is a string syntax for identifying a specific value within a JSON
      document.

9. **JsonPatch**
    - *Description:* Represents a JSON Patch, which is a set of operations for modifying a JSON document.
