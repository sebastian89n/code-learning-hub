# Jakarta Messaging (JMS)

Jakarta Messaging (previously Java Message Service) is a Java-based messaging standard that allows applications to
communicate asynchronously by
sending and receiving messages. It provides a way for different software components to exchange information and data in
a reliable, loosely coupled, and platform-independent manner. JMS is commonly used in enterprise and distributed systems
to build scalable and reliable messaging solutions.

## Modules

- **jms-basics** - sample application with code snippets demonstrating JMS features
- **jms-task-manager** - sample JMS mini app with client/server

## Installing Artemis

1. **Download Apache ActiveMQ Artemis**:
    - Visit the official Apache ActiveMQ Artemis download
      page: [Download Page](https://activemq.apache.org/components/artemis/download/).
    - Choose the desired version of Artemis for your platform and download it.

2. **Unzip the Downloaded Archive**:
    - Locate the downloaded Artemis archive file and unzip it to your preferred directory on your system.

3. **Create a Broker Instance**:
    - Open a terminal or command prompt.
    - Navigate to the `bin` folder of the extracted Apache ActiveMQ Artemis distribution using the `cd` command.

   ```shell
   cd path_to_artemis/bin
   ```

4. **Create a New Artemis Broker Instance:**
    - Execute the following command to create a new Artemis broker instance. Replace `your_broker_directory` with the
      desired path for your broker.
   ```shell
   artemis create your_broker_directory
   ```
   For example:
   ```shell
   artemis create C:\Users\snowak\Dev\apache-artemis-2.31.2\brokers\mybroker
   ```

5. **Navigate to Your Broker Directory:**
    - Execute the following command to create a new Artemis broker instance. Replace `your_broker_directory` with the
      desired path for your broker.
   ```shell
   artemis create your_broker_directory
   ```
   For example:
      ```shell
   cd C:\Users\snowak\Dev\apache-artemis-2.31.2\brokers\mybroker
   ```
6. **Start the Artemis Broker:**
    - Start the Artemis broker using the following command:
   ```shell
   artemis run
   ```
7. **Access the Artemis Console:**
    - Once you have started the Apache ActiveMQ Artemis broker, you can access the Artemis console by opening a web
      browser and navigating to the following URL:
      http://localhost:8161/console/

## Key Concepts

To understand JMS as a Java developer, you should be familiar with the following key concepts:

### Messaging Models

1. **Point-to-Point (P2P)**: In this model, messages are sent from a single sender to a single receiver. It is
   characterized by queues where messages are stored until the receiver retrieves and processes them.

2. **Publish-Subscribe (Pub/Sub)**: This model involves multiple subscribers receiving messages from one or more
   publishers. Subscribers subscribe to specific topics, and messages are broadcast to all interested subscribers.

### JMS Providers

JMS is an API standard, and it requires a JMS provider to implement the messaging infrastructure. Common JMS providers
include Apache ActiveMQ, Artemis, IBM WebSphere MQ, and Oracle WebLogic JMS.

### JMS Components

1. **ConnectionFactory**: A ConnectionFactory is used to create connections to the JMS provider. It encapsulates the
   configuration details necessary for establishing a connection.

2. **Connection**: A Connection represents a communication channel between the Java application and the JMS provider. It
   is used to create Session objects.

3. **Session**: A Session provides a transactional context for producing and consuming messages. It is created from a
   Connection and allows you to create producers and consumers.

4. **Producer**: A Producer is responsible for sending messages to a JMS destination (queue or topic).

5. **Consumer**: A Consumer is responsible for receiving and processing messages from a JMS destination.

6. **Destination**: A Destination represents a logical endpoint for message exchange, which can be either a queue (for
   P2P) or a topic (for Pub/Sub).

### Message Types

JMS supports various message types, including:

- **TextMessage**: Contains plain text.
- **ObjectMessage**: Contains a serialized Java object.
- **MapMessage**: Contains a set of key-value pairs.
- **BytesMessage**: Contains a stream of uninterpreted bytes.
- **StreamMessage**: Contains a stream of primitive data types.

### JMS Headers & Properties

JMS messages can carry additional information through headers and properties:

#### Headers

- **JMSDestination**: Specifies the destination (queue or topic) to which the message is sent.
- **JMSDeliveryMode**: Indicates whether the message should be persistent or non-persistent.
- **JMSTimestamp**: Records the time when the message was sent.
- **JMSExpiration**: Defines the expiration time for the message.
- **JMSMessageID**: A unique identifier for the message.
- **JMSPriority**: Assigns a priority level to the message.
- **JMSReplyTo**: Specifies the destination where a reply should be sent.
- **JMSRedelivered**: Indicates whether the message has been redelivered.
- **JMSType**: Provides a type identifier for the message content.
- **JMSCorrelationID**: Used to correlate messages.
- **JMSDeliveryTime**: Specifies the delivery time for the message.

#### Properties

Custom properties can be set on JMS messages to convey application-specific data. For example:

```java
message.setStringProperty("key","value");
```

### Message Acknowledgment

JMS provides acknowledgment modes for handling message receipt:

#### Auto-acknowledge (Session.AUTO_ACKNOWLEDGE)

Messages are automatically acknowledged upon successful delivery to the consumer.

#### Client-acknowledge (Session.CLIENT_ACKNOWLEDGE)

Consumers explicitly acknowledge message receipt for more control.

#### Dups-ok-acknowledge (Session.DUPS_OK_ACKNOWLEDGE)

Allows for duplicate message acknowledgment when occasional duplicates are acceptable.

#### Transacted (Session.SESSION_TRANSACTED)

In transacted mode, acknowledgment is handled within a transaction. Messages are acknowledged only when the transaction
is committed, providing atomicity for multiple message operations.

