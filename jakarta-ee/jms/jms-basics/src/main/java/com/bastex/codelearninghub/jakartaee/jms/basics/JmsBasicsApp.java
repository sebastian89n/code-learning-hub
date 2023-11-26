package com.bastex.codelearninghub.jakartaee.jms.basics;

import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsCustomPropertiesTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsDelayMessageTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsDurableSubscriptionsTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsMessageExpirationTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsMessageListenerTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsMessageTypesTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsPriorityTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsReplyToTester;
import com.bastex.codelearninghub.jakartaee.jms.basics.features.JmsSharedSubscriptionsTester;
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
            case "priority" -> JmsPriorityTester.testJmsPriority();
            case "replyTo" -> JmsReplyToTester.testJmsReplyTo();
            case "expiration" -> JmsMessageExpirationTester.testMessageExpiration();
            case "delay" -> JmsDelayMessageTester.testDelayMessage();
            case "customProperties" -> JmsCustomPropertiesTester.testMessageCustomProperties();
            case "messageTypes" -> JmsMessageTypesTester.testMessageTypes();
            case "durableSubscriptions" -> JmsDurableSubscriptionsTester.testDurableSubscriptions();
            case "sharedSubscriptions" -> JmsSharedSubscriptionsTester.testSharedSubscriptions();
            default -> JmsMessageListenerTester.testMessageListener();
        }
    }
}
