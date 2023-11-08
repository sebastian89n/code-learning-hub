package com.bastex.codelearninghub.jakartaee.jms;

import com.bastex.codelearninghub.jakartaee.jms.jms1x.Jms1xP2PTester;
import com.bastex.codelearninghub.jakartaee.jms.jms1x.Jms1xPubSubTester;
import com.bastex.codelearninghub.jakartaee.jms.jms1x.Jms1xQueueBrowserTester;
import com.bastex.codelearninghub.jakartaee.jms.jms2x.Jms2xP2PTester;
import com.bastex.codelearninghub.jakartaee.jms.priority.JmsPriorityTester;
import com.bastex.codelearninghub.jakartaee.jms.reply.JmsReplyToTester;

public class JmsApp {
    public static void main(final String[] args) {
        final String action = args.length == 1 ? args[0] : "default";

        switch (action) {
            case "jms1xP2P" -> Jms1xP2PTester.testJms1xBasicsWithP2P();
            case "jms1xPubSub" -> Jms1xPubSubTester.testJms1xBasicsWithPubSub();
            case "jms1xQueueBrowser" -> Jms1xQueueBrowserTester.testJms1xQueueBrowser();
            case "jms2xP2P" -> Jms2xP2PTester.testJms2xBasicsWithP2P();
            case "jmsPriority" -> JmsPriorityTester.testJmsPriority();
            default -> JmsReplyToTester.testReplyTo();
        }
    }
}
