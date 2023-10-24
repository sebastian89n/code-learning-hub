package com.bastex.codelearninghub.java.jaxp.sax;

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
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class JaxpSaxTester {
    @SneakyThrows
    public static void testSaxParser() {
        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        final SAXParser saxParser = saxParserFactory.newSAXParser();

        final StudentHandler studentHandler = new StudentHandler();
        try (final InputStream studentsInputStream = JaxpSaxTester.class.getClassLoader()
                .getResourceAsStream("students.xml")) {
            saxParser.parse(studentsInputStream, studentHandler);
        }

        final List<Student> students = studentHandler.getStudents()
                .map(Students::getStudents).stream() //
                .flatMap(Collection::stream)
                .toList();

        students.forEach(student -> log.info("Student: {}", student));
    }
}
