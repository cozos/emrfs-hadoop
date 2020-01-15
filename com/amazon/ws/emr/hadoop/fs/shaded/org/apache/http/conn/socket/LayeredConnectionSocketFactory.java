package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract interface LayeredConnectionSocketFactory
  extends ConnectionSocketFactory
{
  public abstract Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, HttpContext paramHttpContext)
    throws IOException, UnknownHostException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.LayeredConnectionSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */