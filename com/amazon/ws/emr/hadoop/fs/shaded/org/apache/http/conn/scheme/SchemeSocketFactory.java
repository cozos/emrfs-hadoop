package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public abstract interface SchemeSocketFactory
{
  public abstract Socket createSocket(HttpParams paramHttpParams)
    throws IOException;
  
  public abstract Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, HttpParams paramHttpParams)
    throws IOException, UnknownHostException, ConnectTimeoutException;
  
  public abstract boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */