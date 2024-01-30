# Jackson

Jackson is a widely-used Java library for handling JSON (JavaScript Object Notation) data. It provides a powerful and
efficient way to parse, generate, and manipulate JSON data within Java applications. Jackson is commonly used for tasks
such as deserialization and serialization of JSON data, making it an essential tool for web services, data exchange, and
configuration management.

Jackson offers two main components: the Streaming API and the Data Binding API, both of which enable developers to work
with JSON data efficiently.

## Streaming API

The Streaming API is a low-level approach that allows you to process JSON data incrementally. It's useful for situations
where you need to read or write JSON data without loading the entire document into memory. Key classes in the Streaming
API include:

- `JsonParser`: Reads JSON data as a stream of tokens, making it memory-efficient and suitable for large datasets.
- `JsonGenerator`: Writes JSON data as a stream, enabling you to create JSON documents incrementally.

The Streaming API provides fine-grained control over the JSON parsing and generation process. Developers can navigate
through the JSON data step by step, handling individual tokens as needed. This approach is beneficial in scenarios with
large or continuously streaming JSON data.

Additional features of the Streaming API include:

- **Event-based Processing:** Developers can register listeners for various JSON events, enabling them to take specific
  actions as the parser encounters different parts of the JSON structure.

- **Memory Efficiency:** Since the parser processes data incrementally, it is memory-efficient and suitable for working
  with large JSON datasets that may not fit entirely into memory.

## Data Binding API

The Data Binding API is a high-level approach that simplifies the mapping of Java objects to JSON and vice versa. It
offers seamless conversion between Java objects and JSON data. Jackson relies on a set of annotations to control the
mapping process.

### Common Use Cases

Jackson is used in a variety of scenarios, including:

- Deserialization of JSON data from HTTP requests in web services.
- Serialization of Java objects to JSON for data storage or transport.
- Configuration management, especially in applications that use JSON-based configuration files.
- Data exchange and interoperability between systems that communicate with JSON.

Jackson's versatility, performance, and ease of use make it a preferred choice for JSON processing in the Java
ecosystem.

### Jackson Data Binding Annotations

- `@JsonCreator`: Annotates a constructor or factory method to indicate how to create instances during deserialization.
  It is useful when the deserialization process requires more than the default constructor.
- `@JsonRootName`: Specifies a root name for the JSON representation of an object. This is useful when you want to wrap
  the serialized JSON with a specific root element.
- `@JsonProperty`: Maps a Java class field or method to a specific JSON property, allowing you to customize the JSON
  key.
- `@JsonPropertyOrder`: Defines the order in which properties of a class should be serialized. This annotation is
  applied to the class and takes an array of property names, indicating the desired serialization order.
- `@JsonInclude`: Controls the inclusion of properties with null or default values in the JSON output.
- `@JsonFormat`: Configures the format of date and time values during serialization and deserialization.
- `@JsonIgnore`: Excludes a Java class field or method from JSON serialization and deserialization.
- `@JsonRawValue`: Used to indicate that a property should be serialized as a raw JSON value without quoting it. This is
  useful when you want to include pre-formatted or complex JSON structures as a property.
- `@JsonCreator`: Annotates a constructor or factory method to indicate how to create instances during deserialization.
- `@JsonAnyGetter` and `@JsonAnySetter`: Allow dynamic handling of properties not explicitly mapped to Java class
  fields.
- `@JsonSubTypes` and `@JsonTypeInfo`: Support polymorphic type handling in JSON data.
- `@JsonSerialize`: Specifies a custom serializer for a property, allowing you to define how a Java object should be
  converted to its JSON representation.
- `@JsonDeserialize`: Specifies a custom deserializer for a property, defining how JSON should be converted back to a
  Java object.

### `ObjectMapper` Class

The `ObjectMapper` class is a central component in Jackson for handling the conversion between Java objects and JSON
data.
It provides methods for serialization and deserialization and acts as a configuration hub for various Jackson features.

Developers commonly use an `ObjectMapper` instance to perform tasks such as:

- Converting Java objects to JSON (`writeValue` methods).
- Reading JSON data into Java objects (`readValue` methods).
- Configuring serialization and deserialization options.

The `ObjectMapper` class simplifies the integration of Jackson into Java applications and provides a convenient and
flexible way to work with JSON data.
