# JAXP: Java API for XML Processing

[ `-Djaxp.debug=1` to print implementation that is being used ]

JAXP, or Java API for XML Processing, is a set of standard APIs for parsing and processing XML documents in Java. It
provides a consistent and flexible way to work with XML data, allowing developers to read, manipulate, and generate XML
content.

## Overview

JAXP consists of a set of APIs and tools for XML processing. It is designed to be vendor-neutral, which means that it
can work with different XML parsers and processors without requiring changes to your code. Different parsers/processors
can be provided via maven dependencies. E.g.Apache Xerces(SAX, DOM, and StAX), Woodstox(StAX), Xalan(only TrAX)

## Document Object Model (DOM)

DOM is a programming interface for working with XML documents as a tree structure. It
allows you to create, modify, and navigate XML documents in memory. DOM parsers read the entire XML document into
memory, making it suitable for smaller documents but potentially memory-intensive for larger ones.

## Simple API for XML (SAX)

SAX is an event-based approach for processing XML documents. SAX parsers read XML
documents sequentially and trigger events as they encounter elements, attributes, and data. SAX is memory-efficient
and is often used for parsing large XML documents.

## Streaming API for XML (StAX)

StAX is a pull-parsing API for processing XML documents. It allows you to read and
write XML content in a streaming fashion, similar to reading a file. StAX provides a balance between the tree-based
approach of DOM and the event-based approach of SAX, offering flexibility and efficiency. It is useful if there's no
need to parse the whole document, you can stop in the middle. StAX however doesn't provide schema validation
mechanism.

## Transformation API for XML(TrAX)

TrAX is a component of the Java API for XML Processing (JAXP). It provides a standard way to perform XML
transformations, such as XSLT (Extensible Stylesheet Language Transformations), in Java applications. TrAX is used to
apply XSLT stylesheets to XML documents, enabling the conversion of XML data into different formats or structures.



