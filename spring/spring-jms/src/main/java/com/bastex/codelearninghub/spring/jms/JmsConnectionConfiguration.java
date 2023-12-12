package com.bastex.codelearninghub.spring.jms;

import com.bastex.codelearninghub.spring.jms.listeners.NotificationMessageListener;
import lombok.SneakyThrows;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.Session;
import java.time.Duration;

@Configuration
public class JmsConnectionConfiguration {
    /**
     * If using Spring Boot, you can ignore defining Connection and just configure most things in application.properties
     */
    @SneakyThrows
    @Bean
    ActiveMQConnectionFactory connectionFactory(@Value("${spring.artemis.broker-url}") final String brokerUrl,
                                                @Value("${spring.artemis.user}") final String user,
                                                @Value("${spring.artemis.password}") final String password) {
        final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUser(user);
        connectionFactory.setPassword(password);

        return connectionFactory;
    }

    /**
     * A way to initialize consumer with various options like concurrency, message listener, pubSubDomain(false->p2p queue, true pub-sub topic) etc
     */
    @Bean
    DefaultMessageListenerContainer topicMessageListenerContainer(final ActiveMQConnectionFactory connectionFactory, @Value("${topics.notificationTopic}") final String notificationTopic) {
        final DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestinationName(notificationTopic);
        container.setMessageListener(new NotificationMessageListener());
        container.setCacheLevel(DefaultMessageListenerContainer.CACHE_CONSUMER);

        container.setPubSubDomain(true);
        container.setSessionTransacted(true);
        container.setConcurrency("1-3");
        container.setTransactionTimeout((int) Duration.ofMinutes(10).toSeconds());

        return container;
    }

    /**
     * Abstraction to simplify sending of JMS messages
     */
    @Bean
    JmsTemplate p2pJmsTemplate(final ActiveMQConnectionFactory connectionFactory) {
        final JmsTemplate jmsTemplate = prepareJmsTemplate(connectionFactory);
        jmsTemplate.setPubSubDomain(false);

        return jmsTemplate;
    }

    @Bean
    JmsTemplate pubSubJmsTemplate(final ActiveMQConnectionFactory connectionFactory) {
        final JmsTemplate jmsTemplate = prepareJmsTemplate(connectionFactory);
        jmsTemplate.setPubSubDomain(true);

        return jmsTemplate;
    }

    private static JmsTemplate prepareJmsTemplate(final ActiveMQConnectionFactory connectionFactory) {
        final JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setSessionTransacted(true);
        jmsTemplate.setReceiveTimeout(12000);
        jmsTemplate.setDeliveryPersistent(true);
        jmsTemplate.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        jmsTemplate.setExplicitQosEnabled(true);
        return jmsTemplate;
    }
}
