package com.bastex.codelearninghub.spring.jms;

import com.bastex.codelearninghub.spring.jms.model.NotificationJmsDTO;
import com.bastex.codelearninghub.spring.jms.model.TaskJmsDTO;
import com.bastex.codelearninghub.spring.jms.senders.NotificationSender;
import com.bastex.codelearninghub.spring.jms.senders.TaskSender;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

import java.time.Instant;
import java.util.UUID;

@EnableJms
@SpringBootApplication
public class SpringJmsApp {

    @SneakyThrows
    public static void main(final String[] args) {
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringJmsApp.class, args)) {
            final TaskJmsDTO task = new TaskJmsDTO(UUID.randomUUID().toString(), "Some task", Instant.now());
            final TaskSender taskSender = applicationContext.getBean(TaskSender.class);
            taskSender.sendTask(task);

            final NotificationJmsDTO notification = new NotificationJmsDTO(UUID.randomUUID().toString(), "Notification", Instant.now());
            final NotificationSender notificationSender = applicationContext.getBean(NotificationSender.class);
            notificationSender.sendMessage(notification);

            Thread.currentThread().join();
        }
    }
}
