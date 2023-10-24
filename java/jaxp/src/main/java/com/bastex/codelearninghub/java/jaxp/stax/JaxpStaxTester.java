package com.bastex.codelearninghub.java.jaxp.stax;

import com.bastex.codelearninghub.java.jaxp.model.students.Student;
import com.bastex.codelearninghub.java.jaxp.model.students.Students;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.BIRTHDATE_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.FIRSTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.LASTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.STUDENT_ELEMENT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class JaxpStaxTester {
    @SneakyThrows
    public static void testStaxParser() {
        final Students students = parseDocument();
        log.info("Students: {}", students);
    }

    private static Students parseDocument() throws IOException, XMLStreamException {
        final Students students = new Students();

        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (final InputStream studentsInputStream = JaxpStaxTester.class.getClassLoader()
                .getResourceAsStream("students.xml")) {
            final XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(studentsInputStream);
            Student currentStudent = new Student();
            // TODO refactor
            while (eventReader.hasNext()) {
                XMLEvent xmlEvent = eventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    final StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case STUDENT_ELEMENT -> currentStudent = new Student();
                        case FIRSTNAME_ELEMENT -> {
                            xmlEvent = eventReader.nextEvent();
                            if (xmlEvent.isCharacters()) {
                                currentStudent.setFirstName(xmlEvent.asCharacters().getData());
                            }
                        }
                        case LASTNAME_ELEMENT -> {
                            xmlEvent = eventReader.nextEvent();
                            if (xmlEvent.isCharacters()) {
                                currentStudent.setLastName(xmlEvent.asCharacters().getData());
                            }
                        }
                        case BIRTHDATE_ELEMENT -> {
                            xmlEvent = eventReader.nextEvent();
                            if (xmlEvent.isCharacters()) {
                                final String birthDateAsText = xmlEvent.asCharacters().getData();
                                if (birthDateAsText != null && !birthDateAsText.isBlank()) {
                                    final LocalDate birthDate = LocalDate.parse(birthDateAsText);
                                    currentStudent.setBirthDate(birthDate);
                                }
                            }
                        }
                    }
                } else if (xmlEvent.isEndElement()) {
                    final EndElement endElement = xmlEvent.asEndElement();
                    final boolean isEndOfStudentElement = endElement.getName().getLocalPart().equals("student");
                    if (isEndOfStudentElement) {
                        students.getStudents().add(currentStudent);
                    }
                }
            }
        }
        return students;
    }
}
