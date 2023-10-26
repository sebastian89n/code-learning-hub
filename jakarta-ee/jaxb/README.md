# jaxb

JAXB - Jakarta XML Binding (previously Java Architecture for XML Binding)

JAXB provides a fast and convenient way to marshal (write) Java objects into XML and unmarshal (read) XML into objects.
It supports a binding framework that maps XML elements and attributes to Java fields and properties using Java
annotations. It also supports schema validation.

* **@XmlRootElement**: The name of the root XML element is derived from the class name, and we can also specify the name
  of the root element of the XML using its name attribute.
* **@XmlType**: define the order in which the fields are written in the XML file
* **@XmlElement**: define the actual XML element name that will be used
* **@XmlAttribute**: define the id field is mapped as an attribute instead of an element
* **@XmlTransient**: annotate fields that we don’t want to be included in XML

Furthermore, JAXB-2 Maven plugin(jaxb2-maven-plugin) can be configured to generate Java classes with JAXB annotations
based on XSD schema or
generate schema based on JAXB annotated classes.
