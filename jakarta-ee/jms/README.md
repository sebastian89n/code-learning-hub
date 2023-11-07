# Jakarta Messaging (JMS)

Jakarta Messaging (previously Java Message Service) is a Java-based messaging standard that allows applications to
communicate asynchronously by
sending and receiving messages. It provides a way for different software components to exchange information and data in
a reliable, loosely coupled, and platform-independent manner. JMS is commonly used in enterprise and distributed systems
to build scalable and reliable messaging solutions.

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

### Message Acknowledgment

JMS allows you to acknowledge the receipt of messages, ensuring reliable and once-only delivery. Acknowledgment modes
include AUTO_ACKNOWLEDGE, CLIENT_ACKNOWLEDGE, and more.

## Using JMS in Java

To work with JMS in Java, you'll typically need to perform the following steps:

1. Create a ConnectionFactory.
2. Create a Connection.
3. Create a Session.
4. Create a Producer or Consumer.
5. Send or receive messages.
6. Close resources and connections when done.

## Conclusion

JMS is a powerful technology for building messaging systems in Java applications. It offers flexibility, reliability,
and scalability when it comes to asynchronous communication. Understanding the key concepts and components of JMS is
essential for Java developers looking to implement robust messaging solutions in their projects.
