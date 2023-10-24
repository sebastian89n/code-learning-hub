package com.bastex.codelearninghub.java.jaxp.sax.handler;

import com.bastex.codelearninghub.java.jaxp.model.students.Student;
import com.bastex.codelearninghub.java.jaxp.model.students.Students;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.Optional;

import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.BIRTHDATE_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.FIRSTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.LASTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentElements.STUDENT_ELEMENT;

@Slf4j
public class StudentHandler extends DefaultHandler {
    private final StringBuilder elementValueBuilder = new StringBuilder();

    private Students students;

    @Override
    public void startDocument() throws SAXException {
        log.info("Starting to parse students xml document");
        students = new Students();
    }

    @Override
    public void endDocument() throws SAXException {
        log.info("Finished parsing students xml document");
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        switch (qName) {
            case STUDENT_ELEMENT -> students.getStudents().add(new Student());
            case FIRSTNAME_ELEMENT, LASTNAME_ELEMENT, BIRTHDATE_ELEMENT -> elementValueBuilder.setLength(0);
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        switch (qName) {
            case FIRSTNAME_ELEMENT -> getLatestStudent().setFirstName(elementValueBuilder.toString());
            case LASTNAME_ELEMENT -> getLatestStudent().setLastName(elementValueBuilder.toString());
            case BIRTHDATE_ELEMENT -> {
                final String dateAsText = elementValueBuilder.toString();
                if (!dateAsText.isBlank()) {
                    final LocalDate birthDate = LocalDate.parse(dateAsText);
                    getLatestStudent().setBirthDate(birthDate);
                }
            }
        }
    }

    @Override
    public void characters(final char[] ch, final int start, final int length) throws SAXException {
        elementValueBuilder.append(ch, start, length);
    }

    private Student getLatestStudent() {
        return students.getStudents().getLast();
    }

    public Optional<Students> getStudents() {
        return Optional.ofNullable(students);
    }
}
