package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.services.XmlTranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

@Slf4j
public class SpringContextXmlApp {
    public static void main(final String[] args) {
        // Xml context example by loading context with ClassPathXmlApplicationContext by providing xml file from classpath
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading Spring context from xml file
        try (final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml")) {
            final XmlTranslationService xmlTranslationService = applicationContext.getBean(XmlTranslationService.class);
            xmlTranslationService.printComponentType();
            xmlTranslationService.printComponentType();

            final Set<String> supportedLanguages = xmlTranslationService.getSupportedLanguages();
            log.info("Supported languages: {}", String.join(", ", supportedLanguages));

            xmlTranslationService.getTranslationServices() //
                    .forEach(translationService -> log.info(translationService.getGreeting()));
        }
    }
}
