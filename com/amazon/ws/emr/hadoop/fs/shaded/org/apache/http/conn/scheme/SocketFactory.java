package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public abstract interface SocketFactory
{
  public abstract Socket createSocket()
    throws IOException;
  
  public abstract Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
    throws IOException, UnknownHostException, ConnectTimeoutException;
  
  public abstract boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */