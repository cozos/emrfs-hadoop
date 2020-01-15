package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils.HttpContextUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.PlainConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;

public class SdkPlainSocketFactory
  extends PlainConnectionSocketFactory
{
  public Socket createSocket(HttpContext ctx)
    throws IOException
  {
    if (HttpContextUtils.disableSocketProxy(ctx)) {
      return new Socket(Proxy.NO_PROXY);
    }
    return super.createSocket(ctx);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.SdkPlainSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */