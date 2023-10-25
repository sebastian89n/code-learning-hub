package com.bastex.codelearninghub.java.jaxp.dom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class DomCreateDocumentHelper {
    static void createNewDocument(final DocumentBuilder documentBuilder) {
        final Document document = documentBuilder.newDocument();
        final Element rootElement = document.createElement("students");
        document.appendChild(rootElement);

        final Element student = document.createElement("student");
        student.setAttribute("id", "123");

        final Element firstname = document.createElement("firstname");
        firstname.appendChild(document.createTextNode("John"));

        final Element lastname = document.createElement("lastname");
        lastname.appendChild(document.createTextNode("Smith"));

        final Element birthdate = document.createElement("birthdate");
        birthdate.appendChild(document.createTextNode("1993-12-04"));

        student.appendChild(firstname);
        student.appendChild(lastname);
        student.appendChild(birthdate);
        rootElement.appendChild(student);

        final StringWriter output = transformDocumentToString(document);
        log.info("New document created using DOM:\n{}", output);
    }

    private static StringWriter transformDocumentToString(final Document document) {
        final StringWriter output = new StringWriter();
        try {
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(document), new StreamResult(output));
        } catch (final Exception e) {
            throw new RuntimeException("Unable to convert XML document to String", e);
        }
        return output;
    }
}
