package com.bastex.codelearninghub.designpatterns.behavioral.state;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OpenTCPConnectionState implements TCPConnectionState {
    private final TCPConnection connection;


    public OpenTCPConnectionState(final TCPConnection connection) {
        this.connection = connection;
    }

    @Override
    public void open() {
        log.info("Reinitializing connection");
    }

    @Override
    public void close() {
        connection.setTcpConnectionState(new ClosedTCPConnectionState(connection));
        log.info("Closing connection");
    }

    @Override
    public void acknowledge() throws Exception {
        log.info("Acknowledge");
    }


}
