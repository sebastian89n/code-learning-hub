package com.bastex.codelearninghub.spring5core;

import com.bastex.codelearninghub.spring5core.xml.services.XmlBeanService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5XmlApp {
    public static void main(final String[] args) {
        // Xml context example by loading context with ClassPathXmlApplicationContext by providing xml file from classpath
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading Spring context from xml file
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

        final XmlBeanService configurationInitializedBeanService = applicationContext.getBean(XmlBeanService.class);
        configurationInitializedBeanService.printComponentName();
        configurationInitializedBeanService.printComponentName();
    }
}
