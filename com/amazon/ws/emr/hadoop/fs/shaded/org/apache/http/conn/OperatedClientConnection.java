package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpInetConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public abstract interface OperatedClientConnection
  extends HttpClientConnection, HttpInetConnection
{
  public abstract HttpHost getTargetHost();
  
  public abstract boolean isSecure();
  
  public abstract Socket getSocket();
  
  public abstract void opening(Socket paramSocket, HttpHost paramHttpHost)
    throws IOException;
  
  public abstract void openCompleted(boolean paramBoolean, HttpParams paramHttpParams)
    throws IOException;
  
  public abstract void update(Socket paramSocket, HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */