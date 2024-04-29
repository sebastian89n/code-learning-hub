# Jakarta JSON Binding

Jakarta JSON Binding(JSON-B) is a specification that allows for the serialization and deserialization of Java objects to
and from JSON (
JavaScript Object
Notation) format. It provides a convenient and flexible way to work with JSON data in Java applications.

JSON-B is a part of the Jakarta EE platform, and it aims to simplify the process of converting Java
objects to JSON format and vice versa. It provides annotations for customizing the mapping between Java objects and JSON
data, making it easy to control the serialization and deserialization process.

## Key Features

- **Annotation-Based Configuration:** JSON-B uses annotations to customize the serialization and deserialization
  process. This allows developers to control how Java objects are represented in JSON and vice versa.

- **Default Mapping:** JSON-B provides default mapping rules for common Java types, simplifying the serialization and
  deserialization of objects without the need for extensive configuration.

- **Customization:** Developers can customize the mapping process by using annotations
  like `@JsonbProperty`, `@JsonbTransient`, and more. These annotations provide fine-grained control over the JSON
  representation of Java objects.

- **Support for Collections and Maps:** JSON-B supports the serialization and deserialization of Java collections (e.g.,
  List, Set, Map) to and from JSON, providing a seamless integration with complex data structures.

- **Date and Number Formatting:** JSON-B allows developers to control the formatting of dates and numbers during
  serialization, ensuring consistent representation in the JSON output.

## JSON-B Annotations

1. **@JsonbAnnotation**
    - *Description:* Base annotation for all JSON-B annotations.

2. **@JsonbDateFormat**
    - *Description:* Specifies the format for date and time fields during serialization and deserialization.
    - Example: `@JsonbDateFormat('yyyy-MM-dd'T'HH:mm:ss')`

3. **@JsonbNillable**
    - *Description:* Configures whether null values should be included in the JSON output.

4. **@JsonbNumberFormat**
    - *Description:* Specifies the format for numeric fields during serialization and deserialization.
    - Example: `@JsonbNumberFormat('###.##')`

5. **@JsonbProperty**
    - *Description:* Maps a Java class field or property to a custom name in the JSON representation.
    - Example: `@JsonbProperty('customName')`

6. **@JsonbPropertyOrder**
    - *Description:* Specifies the order of properties in the JSON output.
    - Example: `@JsonbPropertyOrder({'name', 'age', 'address'})`

7. **@JsonbTransient**
    - *Description:* Excludes a Java class field or property from being serialized or deserialized.

8. **@JsonbTypeAdapter**
    - *Description:* Specifies a custom adapter class for customizing the serialization and deserialization of a
      specific type.
    - Example: `@JsonbTypeAdapter(MyCustomAdapter.class)`

9. **@JsonbTypeDeserializer**
    - *Description:* Specifies a custom deserializer for a specific type.
    - Example: `@JsonbTypeDeserializer(MyCustomDeserializer.class)`

10. **@JsonbTypeSerializer**
    - *Description:* Specifies a custom serializer for a specific type.
    - Example: `@JsonbTypeSerializer(MyCustomSerializer.class)`

11. **@JsonbVisibility**
    - *Description:* Specifies a custom visibility strategy for determining which fields should be included in the JSON
      output.
    - Example: `@JsonbVisibility(MyCustomVisibility.class)`
