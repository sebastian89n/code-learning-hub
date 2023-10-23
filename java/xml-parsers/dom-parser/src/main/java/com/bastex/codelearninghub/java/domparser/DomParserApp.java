package com.bastex.codelearninghub.java.domparser;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

@Slf4j
public class DomParserApp {
    public static void main(final String[] args) throws Exception {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        queryExistingDocument(documentBuilder);
        createNewDocument(documentBuilder);
    }

    private static void queryExistingDocument(final DocumentBuilder documentBuilder) throws IOException, SAXException {
        final Document document;
        try (final InputStream students = DomParserApp.class.getClassLoader().getResourceAsStream("students.xml")) {
            document = documentBuilder.parse(students);
        }
        document.getDocumentElement().normalize();

        log.info("Root element name: {}", document.getDocumentElement().getNodeName());
        final NodeList students = document.getElementsByTagName("student");

        for (int i = 0; i < students.getLength(); i++) {
            final Node studentNode = students.item(i);

            if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                final Element student = (Element) studentNode;
                final String id = student.getAttribute("id");
                final String firstname = extractRequiredValueFromTag(student, "firstname");
                final String lastname = extractRequiredValueFromTag(student, "lastname");
                final String birthdate = extractRequiredValueFromTag(student, "birthdate");
                log.info("Student {} {} [{}], id {}", firstname, lastname, birthdate, id);
            }
        }
    }

    private static void createNewDocument(final DocumentBuilder documentBuilder) {
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
        log.info("XML:\n{}", output);
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

    private static String extractRequiredValueFromTag(final Element element, final String tagName) {
        final NodeList elementsByTagName = element.getElementsByTagName(tagName);
        if (elementsByTagName.getLength() == 0) {
            throw new IllegalStateException("Unable to parse document");
        }

        return elementsByTagName.item(0).getTextContent();
    }
}
