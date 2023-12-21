package com.bastex.codelearninghub.java.jaxp.trax;

import com.bastex.codelearninghub.java.jaxp.stax.JaxpStaxTester;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.StringWriter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class JaxpTraxTester {
    @SneakyThrows
    public static void testTrax() {
        try (final InputStream studentsIs = JaxpStaxTester.class.getClassLoader()
                .getResourceAsStream("students.xml"); final InputStream stylesheetIs = JaxpStaxTester.class.getClassLoader()
                .getResourceAsStream("stylesheet.xslt")) {

            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer(new StreamSource(stylesheetIs));

            final StringWriter resultWriter = new StringWriter();
            transformer.transform(new StreamSource(studentsIs), new StreamResult(resultWriter));

            log.info("Result: {}", resultWriter);
        }
    }
}
