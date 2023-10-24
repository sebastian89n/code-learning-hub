# jaxp

JAXP - Java API for XML Processing

JAXP is a widely-used Java API that offers a standard way to process XML data. It provides a set of interfaces and
classes that enable us to parse, transform, and validate XML documents. JAXP is part of the Java Standard Edition (SE)
platform and is supported by various XML parsers and processors.

Use -Djaxp.debug=1 to show used implementation

### DOM - Document Object Model

The DOM parser does not rely on events. Moreover, it loads the whole XML document into memory to parse it. SAX is more
memory-efficient than DOM

DOM has its benefits, too. For example, DOM supports XPath. It makes it also easy to operate on the whole document tree
at once since the document is loaded into memory.

### SAX - the Simple API for XML

SAX is an API used to parse XML documents. It is based on events generated while reading through the document. Callback
methods receive those events. A custom handler contains those callback methods.

The API is efficient because it drops events right after the callbacks received them. Therefore, SAX has efficient
memory management, unlike DOM, for example.

### StAX - Streaming API for XML

StAX is more recent than SAX and DOM.

The main difference with SAX is that StAX uses a pull mechanism instead of SAX’s push mechanism (using callbacks).
This means the control is given to the client to decide when the events need to be pulled. Therefore, there is no
obligation to pull the whole document if only a part of it is needed.

It provides an easy API to work with XML with a memory-efficient way of parsing.

Unlike SAX, it doesn’t provide schema validation as one of its features.
