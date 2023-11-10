package com.bastex.codelearninghub.jakartaee.jms.basics;

import com.bastex.codelearninghub.jakartaee.jms.basics.headers.JmsCustomPropertiesTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.headers.JmsDelayMessageTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.headers.JmsMessageExpirationTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.headers.JmsMessageTypesTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.headers.JmsPriorityTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.headers.JmsReplyToTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.jms1x.Jms1xP2PTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.jms1x.Jms1xPubSubTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.jms1x.Jms1xQueueBrowserTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.jms2x.Jms2xP2PTester;

public class JmsBasicsApp {
    public static void main(final String[] args) {
        final String action = args.length == 1 ? args[0] : "default";

        switch (action) {
            case "jms1xP2P" -> Jms1xP2PTester.testJms1xBasicsWithP2P();
            case "jms1xPubSub" -> Jms1xPubSubTester.testJms1xBasicsWithPubSub();
            case "jms1xQueueBrowser" -> Jms1xQueueBrowserTester.testJms1xQueueBrowser();
            case "jms2xP2P" -> Jms2xP2PTester.testJms2xBasicsWithP2P();
            case "jmsPriority" -> JmsPriorityTester.testJmsPriority();
            case "jmsReplyTo" -> JmsReplyToTester.testJmsReplyTo();
            case "jmsExpiration" -> JmsMessageExpirationTester.testJmsMessageExpiration();
            case "jmsDelay" -> JmsDelayMessageTester.testJmsDelayMessage();
            case "jmsCustomProperties" -> JmsCustomPropertiesTester.testJmsCustomProperties();
            default -> JmsMessageTypesTester.testJmsMessageTypes();
        }
    }
}
