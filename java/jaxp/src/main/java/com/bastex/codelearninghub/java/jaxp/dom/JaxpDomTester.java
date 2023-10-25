package com.bastex.codelearninghub.java.jaxp.dom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JaxpDomTester {
    @SneakyThrows
    public static void testDomParser() {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        DomValidationHelper.validateSchema();
        DomParsingHelper.parseExistingDocument(documentBuilder);
        DomCreateDocumentHelper.createNewDocument(documentBuilder);
    }
}
