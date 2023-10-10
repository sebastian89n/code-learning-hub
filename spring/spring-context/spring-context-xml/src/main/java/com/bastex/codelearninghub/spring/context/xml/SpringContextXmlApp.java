package com.bastex.codelearninghub.spring.context.xml;

import com.bastex.codelearninghub.spring.context.xml.services.XmlTranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Slf4j
public class SpringContextXmlApp {
    public static void main(final String[] args) {
        // Xml context example by loading context with ClassPathXmlApplicationContext by providing xml file from classpath
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading Spring context from xml file
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

        final XmlTranslationService xmlTranslationService = applicationContext.getBean(XmlTranslationService.class);
        xmlTranslationService.printComponentType();
        xmlTranslationService.printComponentType();

        final List<String> textToTranslate = xmlTranslationService.getTextToTranslate();
        log.info(String.join("\n", textToTranslate));

        xmlTranslationService.getTranslationServices() //
                .forEach(translationService -> log.info(translationService.getGreeting()));
    }
}
