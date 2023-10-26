package com.bastex.codelearninghub.java.jaxp.sax.handler;

import com.bastex.codelearninghub.java.jaxp.model.students.Student;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.BIRTHDATE_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.FIRSTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.LASTNAME_ELEMENT;
import static com.bastex.codelearninghub.java.jaxp.model.students.StudentXmlConstants.STUDENT_ELEMENT;

@Slf4j
public class StudentHandler extends DefaultHandler {
    private final StringBuilder elementValueBuilder = new StringBuilder();

    @Getter
    private final List<Student> students = new ArrayList<>();

    @Override
    public void startDocument() {
        log.info("Starting to parse students xml document");
    }

    @Override
    public void endDocument() {
        log.info("Finished parsing students xml document");
    }

    @Override
    public void startElement(final String uri, final String localName, final String elementName, final Attributes attributes) {
        switch (elementName) {
            case STUDENT_ELEMENT -> {
                final String id = attributes.getValue("id");
                final Student student = new Student();
                student.setId(id);
                students.add(student);
            }
            case FIRSTNAME_ELEMENT, LASTNAME_ELEMENT, BIRTHDATE_ELEMENT -> elementValueBuilder.setLength(0);
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String elementName) {
        switch (elementName) {
            case FIRSTNAME_ELEMENT -> getLatestStudent().setFirstName(elementValueBuilder.toString());
            case LASTNAME_ELEMENT -> getLatestStudent().setLastName(elementValueBuilder.toString());
            case BIRTHDATE_ELEMENT -> {
                final String dateAsText = elementValueBuilder.toString();
                final LocalDate birthDate = LocalDate.parse(dateAsText);
                getLatestStudent().setBirthDate(birthDate);
            }
        }
    }

    @Override
    public void characters(final char[] ch, final int start, final int length) {
        elementValueBuilder.append(ch, start, length);
    }

    @Override
    public void error(final SAXParseException e) throws SAXException {
        log.error("Error during parsing of xml document", e);
        throw e;
    }

    @Override
    public void fatalError(final SAXParseException e) throws SAXException {
        log.error("Fatal error during parsing of xml document", e);
        super.fatalError(e);
    }

    @Override
    public void warning(final SAXParseException e) {
        log.warn("Encountered a warning during parsing of xml document", e);
    }

    private Student getLatestStudent() {
        return students.getLast();
    }
}
