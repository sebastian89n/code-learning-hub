package com.bastex.codelearninghub.designpatterns.behavioral.state;


public class StateApp {
    public static void main(final String[] args) throws Exception {
        final TCPConnection connection = new TCPConnection();

        connection.open();

        connection.acknowledge();
        connection.close();
        //connection.acknowledge();
    }
}
