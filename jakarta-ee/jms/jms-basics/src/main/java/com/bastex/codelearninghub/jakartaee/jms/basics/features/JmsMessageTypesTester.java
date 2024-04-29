package com.bastex.codelearninghub.jakartaee.jms.basics.features;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.BytesMessage;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.StreamMessage;
import javax.naming.InitialContext;
import java.io.Serial;
import java.io.Serializable;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsMessageTypesTester {
    @SneakyThrows
    public static void testMessageTypes() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();
            final JMSConsumer consumer = jmsContext.createConsumer(destinationQueue);

            testBytesMessage(jmsContext, producer, destinationQueue, consumer);
            testStreamMessage(jmsContext, producer, destinationQueue, consumer);
            testMapMessage(jmsContext, producer, destinationQueue, consumer);
            testObjectMessage(jmsContext, producer, destinationQueue, consumer);
        }
    }

    private static void testBytesMessage(final JMSContext jmsContext, final JMSProducer producer, final Queue destinationQueue, final JMSConsumer consumer) throws JMSException {
        final BytesMessage bytesMessage = jmsContext.createBytesMessage();
        bytesMessage.writeUTF("Hello World");
        bytesMessage.writeLong(777L);

        producer.send(destinationQueue, bytesMessage);

        final BytesMessage receivedMessage = (BytesMessage) consumer.receive();
        log.info("Received UTF from BytesMessage: {}", receivedMessage.readUTF());
        log.info("Received Long from BytesMessage: {}", receivedMessage.readLong());
    }

    private static void testStreamMessage(final JMSContext jmsContext, final JMSProducer producer, final Queue destinationQueue, final JMSConsumer consumer) throws JMSException {
        final StreamMessage streamMessage = jmsContext.createStreamMessage();
        streamMessage.writeBoolean(true);
        streamMessage.writeFloat(2.5F);

        producer.send(destinationQueue, streamMessage);

        final StreamMessage receivedStreamMessage = (StreamMessage) consumer.receive();
        log.info("Received Boolean from StreamMessage: {}", receivedStreamMessage.readBoolean());
        log.info("Received Float from StreamMessage: {}", receivedStreamMessage.readFloat());
    }

    private static void testMapMessage(final JMSContext jmsContext, final JMSProducer producer, final Queue destinationQueue, final JMSConsumer consumer) throws JMSException {
        final MapMessage mapMessage = jmsContext.createMapMessage();
        mapMessage.setBoolean("active", true);
        mapMessage.setString("user", "admin");

        producer.send(destinationQueue, mapMessage);

        final MapMessage receivedMessage = (MapMessage) consumer.receive();
        log.info("Received boolean from MapMessage: {}", receivedMessage.getBoolean("active"));
        log.info("Received String from MapMessage: {}", receivedMessage.getString("user"));
    }

    private static void testObjectMessage(final JMSContext jmsContext, final JMSProducer producer, final Queue destinationQueue, final JMSConsumer consumer) throws JMSException {
        final ObjectMessage objectMessage = jmsContext.createObjectMessage();
        final User adminUser = new User(1L, "admin");
        objectMessage.setObject(adminUser);

        producer.send(destinationQueue, objectMessage);
        // or use methods to send payload directly(also for other types like maps, bytes etc.):
        // producer.send(destinationQueue, adminUser);
        // User user = consumer.receiveBody(User.class);

        final ObjectMessage receivedMessage = (ObjectMessage) consumer.receive();
        log.info("Received Object from ObjectMessage: {}", receivedMessage.getObject());
    }

    private record User(long id, String username) implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
    }
}
