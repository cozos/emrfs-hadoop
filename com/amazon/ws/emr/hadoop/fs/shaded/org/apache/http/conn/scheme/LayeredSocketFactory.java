package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public abstract interface LayeredSocketFactory
  extends SocketFactory
{
  public abstract Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.LayeredSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */