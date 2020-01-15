package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpInetConnection;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSession;

public abstract interface ManagedHttpClientConnection
  extends HttpClientConnection, HttpInetConnection
{
  public abstract String getId();
  
  public abstract void bind(Socket paramSocket)
    throws IOException;
  
  public abstract Socket getSocket();
  
  public abstract SSLSession getSSLSession();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */