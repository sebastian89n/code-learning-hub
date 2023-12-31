package com.bastex.codelearninghub.java.jaxp.stax;

import com.bastex.codelearninghub.java.jaxp.model.students.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.BIRTHDATE_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.FIRSTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.LASTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.STUDENT_ELEMENT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class JaxpStaxTester {
    @SneakyThrows
    public static void testStaxParser() {
        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try (final InputStream studentsIs = JaxpStaxTester.class.getClassLoader()
                .getResourceAsStream("students.xml")) {
            final List<Student> students = parseStudents(xmlInputFactory, studentsIs);

            log.info("Students parsed with StAX:");
            students.forEach(student -> log.info("{}", student));
        }
    }

    private static List<Student> parseStudents(final XMLInputFactory xmlInputFactory, final InputStream studentsIs) throws XMLStreamException {
        final List<Student> students = new ArrayList<>();

        final XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(studentsIs);
        Student currentStudent = new Student();
        while (eventReader.hasNext()) {
            final XMLEvent xmlEvent = eventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                final StartElement startElement = xmlEvent.asStartElement();
                final String elementName = startElement.getName().getLocalPart();

                switch (elementName) {
                    case STUDENT_ELEMENT -> {
                        final Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        currentStudent = new Student();
                        currentStudent.setId(idAttr.getValue());
                    }
                    case FIRSTNAME_ELEMENT -> {
                        final String firstName = extractNextInlineValue(eventReader);
                        currentStudent.setFirstName(firstName);
                    }
                    case LASTNAME_ELEMENT -> {
                        final String lastName = extractNextInlineValue(eventReader);
                        currentStudent.setLastName(lastName);
                    }
                    case BIRTHDATE_ELEMENT -> {
                        final String birthDateAsText = extractNextInlineValue(eventReader);
                        currentStudent.setBirthDate(LocalDate.parse(birthDateAsText));
                    }
                }
            } else if (xmlEvent.isEndElement()) {
                final EndElement endElement = xmlEvent.asEndElement();
                final boolean isEndOfStudentElement = endElement.getName().getLocalPart().equals("student");
                if (isEndOfStudentElement) {
                    students.add(currentStudent);
                }
            }
        }

        return students;
    }

    @SneakyThrows(XMLStreamException.class)
    private static String extractNextInlineValue(final XMLEventReader eventReader) {
        if (eventReader.hasNext()) {
            final XMLEvent nextEvent = eventReader.nextEvent();
            if (nextEvent.isCharacters()) {
                final String value = nextEvent.asCharacters().getData();
                if (value == null || value.isBlank()) {
                    throw new IllegalStateException("Unable to extract next inline value. Value is not specified or empty");
                }

                return value;
            } else {
                throw new IllegalStateException("Unable to extract next inline value. Value is not specified or empty.");
            }
        } else {
            throw new IllegalStateException("Unable to extract next inline value. Value is not specified or empty.");
        }
    }
}
