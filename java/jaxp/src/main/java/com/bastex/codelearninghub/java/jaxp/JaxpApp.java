package com.bastex.codelearninghub.java.jaxp;

import com.bastex.codelearninghub.java.jaxp.dom.JaxpDomTester;
import com.bastex.codelearninghub.java.jaxp.sax.JaxpSaxTester;
import com.bastex.codelearninghub.java.jaxp.stax.JaxpStaxTester;

public class JaxpApp {
    public static void main(final String[] args) {
        JaxpDomTester.testDomParser();
        JaxpSaxTester.testSaxParser();
        JaxpStaxTester.testStaxParser();
    }
}
