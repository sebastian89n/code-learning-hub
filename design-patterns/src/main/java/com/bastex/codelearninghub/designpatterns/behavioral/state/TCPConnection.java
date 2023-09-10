package com.bastex.codelearninghub.designpatterns.behavioral.state;


import lombok.Setter;

public class TCPConnection {
    @Setter
    private TCPConnectionState tcpConnectionState = new ClosedTCPConnectionState(this);

    public void open() {
        tcpConnectionState.open();
    }

    public void close() {
        tcpConnectionState.close();
    }

    public void acknowledge() throws Exception {
        tcpConnectionState.acknowledge();
    }
}
