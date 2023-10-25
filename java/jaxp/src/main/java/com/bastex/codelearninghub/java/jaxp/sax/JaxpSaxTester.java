package com.bastex.codelearninghub.java.jaxp.sax;

import com.bastex.codelearninghub.java.jaxp.dom.JaxpDomTester;
import com.bastex.codelearninghub.java.jaxp.model.students.Student;
import com.bastex.codelearninghub.java.jaxp.model.students.Students;
import com.bastex.codelearninghub.java.jaxp.sax.handler.StudentHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class JaxpSaxTester {
    private static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    @SneakyThrows
    public static void testSaxParser() {
        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        final StudentHandler studentHandler = new StudentHandler();
        try (final InputStream studentsInputStream = JaxpSaxTester.class.getClassLoader()
                .getResourceAsStream("students.xml");
             final InputStream studentsSchemaIs = JaxpDomTester.class.getClassLoader()
                     .getResourceAsStream("students.xsd")) {

            // Optional for schema validation
            final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final Schema schema = schemaFactory.newSchema(new StreamSource(studentsSchemaIs));
            saxParserFactory.setSchema(schema);

            final SAXParser saxParser = saxParserFactory.newSAXParser();

            saxParser.parse(studentsInputStream, studentHandler);
        }

        final List<Student> students = studentHandler.getStudents()
                .map(Students::getStudents).stream() //
                .flatMap(Collection::stream)
                .toList();

        log.info("Students parsed with SAX:");
        students.forEach(student -> log.info("Student: {}", student));
    }
}
