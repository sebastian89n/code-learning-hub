package com.bastex.codelearninghub.jakartaee.jaxb;

import com.bastex.codelearninghub.jakartaee.jaxb.model.Employees;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.io.StringWriter;
import java.time.Instant;

@Slf4j
public class JaxbApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        final Employees employees = unmarshallEmployees(jaxbContext);

        // setting value to transient field
        employees.getEmployees().forEach(employee -> employee.setLastUpdatedTimestamp(Instant.now()));
        
        marshallEmployees(employees, jaxbContext);
    }

    @SneakyThrows
    private static Employees unmarshallEmployees(final JAXBContext jaxbContext) {
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try (final InputStream employeesIs = JaxbApp.class.getClassLoader().getResourceAsStream("employees.xml")) {
            // optional schema validation when unmarshalling
            final Schema schema = prepareSchema();
            unmarshaller.setSchema(schema);

            final Employees employees = (Employees) unmarshaller.unmarshal(employeesIs);
            log.info("Unmarshalled object: {}", employees);

            return employees;
        }
    }

    @SneakyThrows
    private static void marshallEmployees(final Employees employees, final JAXBContext jaxbContext) {
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "employees.xsd");

        // optional schema validation when marshalling
        final Schema schema = prepareSchema();
        marshaller.setSchema(schema);

        final StringWriter xmlOutput = new StringWriter();
        marshaller.marshal(employees, xmlOutput);

        log.info("Marshalled xml:\n{}", xmlOutput);
    }

    @SneakyThrows
    private static Schema prepareSchema() {
        try (final InputStream employeesSchemaIs = JaxbApp.class.getClassLoader().getResourceAsStream("employees.xsd")) {
            final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            return schemaFactory.newSchema(new StreamSource(employeesSchemaIs));
        }
    }
}
