package com.bastex.codelearninghub.java.jaxp.dom;

import com.bastex.codelearninghub.java.jaxp.model.students.Student;
import com.bastex.codelearninghub.java.jaxp.model.students.Students;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class DomParseHelper {
    static void parseExistingDocument(final DocumentBuilder documentBuilder) throws IOException, SAXException {
        final Document document;
        try (final InputStream studentsIs = JaxpDomTester.class.getClassLoader()
                .getResourceAsStream("students.xml")) {
            document = documentBuilder.parse(studentsIs);
        }
        document.getDocumentElement().normalize();
        log.info("Root element name: {}", document.getDocumentElement().getNodeName());

        final Students students = new Students();

        final NodeList studentsElements = document.getElementsByTagName("student");
        for (int i = 0; i < studentsElements.getLength(); i++) {
            final Node studentNode = studentsElements.item(i);

            if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                final Element student = (Element) studentNode;
                final String id = student.getAttribute("id");
                final String firstname = extractRequiredValueFromTag(student, "firstname");
                final String lastname = extractRequiredValueFromTag(student, "lastname");
                final String birthdate = extractRequiredValueFromTag(student, "birthdate");

                final Student parsedStudent = new Student(id, firstname, lastname, LocalDate.parse(birthdate));
                students.getStudents().add(parsedStudent);
            }
        }

        log.info("Students parsed with DOM:");
        students.getStudents().forEach(student -> log.info("{}", student));
    }

    private static String extractRequiredValueFromTag(final Element element, final String tagName) {
        final NodeList elementsByTagName = element.getElementsByTagName(tagName);
        if (elementsByTagName.getLength() == 0) {
            throw new IllegalStateException("Unable to parse document");
        }

        return elementsByTagName.item(0).getTextContent();
    }
}
