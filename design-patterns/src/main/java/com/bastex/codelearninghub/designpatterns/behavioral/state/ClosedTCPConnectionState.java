package com.bastex.codelearninghub.designpatterns.behavioral.state;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClosedTCPConnectionState implements TCPConnectionState {
    private final TCPConnection connection;

    public ClosedTCPConnectionState(final TCPConnection connection) {
        this.connection = connection;
    }

    @Override
    public void open() {
        log.info("Opening connection");
        connection.setTcpConnectionState(new OpenTCPConnectionState(connection));
    }

    @Override
    public void close() {
        log.info("Already closed connection");
    }

    @Override
    public void acknowledge() throws Exception {
        throw new Exception("Invalid usage of connection");
    }
}
