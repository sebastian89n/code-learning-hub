package com.bastex.codelearninghub.designpatterns.behavioral.state;


public class ClosedTCPConnectionState implements TCPConnectionState {
    private final TCPConnection connection;

    public ClosedTCPConnectionState(final TCPConnection connection) {
        this.connection = connection;
    }

    @Override
    public void open() {
        System.out.println("Opening connection");
        connection.setTcpConnectionState(new OpenTCPConnectionState(connection));
    }

    @Override
    public void close() {
        System.out.println("Already closed connection");
    }

    @Override
    public void acknowledge() throws Exception {
        throw new Exception("Invalid usage of connection");
    }
}
