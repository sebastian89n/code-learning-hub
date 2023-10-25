package com.bastex.codelearninghub.java.jaxp.dom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class DomValidateHelper {
    static void validateSchema() throws SAXException, IOException {
        try (final InputStream studentsIs = JaxpDomTester.class.getClassLoader()
                .getResourceAsStream("students.xml");
             final InputStream studentsSchemaIs = JaxpDomTester.class.getClassLoader()
                     .getResourceAsStream("students.xsd")) {
            final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final Schema schema = schemaFactory.newSchema(new StreamSource(studentsSchemaIs));

            final Validator validator = schema.newValidator();
            validator.validate(new StreamSource(studentsIs));
        }
    }
}
