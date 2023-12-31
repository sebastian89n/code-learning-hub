package com.bastex.codelearninghub.java.jaxp.sax;

import com.bastex.codelearninghub.java.jaxp.dom.JaxpDomTester;
import com.bastex.codelearninghub.java.jaxp.model.students.Student;
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
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class JaxpSaxTester {
    @SneakyThrows
    public static void testSaxParser() {
        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        saxParserFactory.setNamespaceAware(true);

        final StudentHandler studentHandler = new StudentHandler();
        try (final InputStream studentsIs = JaxpSaxTester.class.getClassLoader()
                .getResourceAsStream("students.xml");
             final InputStream studentsSchemaIs = JaxpDomTester.class.getClassLoader()
                     .getResourceAsStream("students.xsd")) {

            // Optional schema validation
            final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final Schema schema = schemaFactory.newSchema(new StreamSource(studentsSchemaIs));
            saxParserFactory.setSchema(schema);

            final SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(studentsIs, studentHandler);
        }

        final List<Student> students = studentHandler.getStudents();

        log.info("Students parsed with SAX:");
        students.forEach(student -> log.info("Student: {}", student));
    }
}
