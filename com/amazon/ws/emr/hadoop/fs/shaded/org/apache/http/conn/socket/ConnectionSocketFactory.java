package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract interface ConnectionSocketFactory
{
  public abstract Socket createSocket(HttpContext paramHttpContext)
    throws IOException;
  
  public abstract Socket connectSocket(int paramInt, Socket paramSocket, HttpHost paramHttpHost, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpContext paramHttpContext)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.ConnectionSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */