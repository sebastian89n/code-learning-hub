package com.bastex.codelearninghub.spring.jms;

import com.bastex.codelearninghub.spring.jms.senders.MessageSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SpringJmsApp {
    public static void main(final String[] args) {
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringJmsApp.class, args)) {
            final MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        }
    }
}
