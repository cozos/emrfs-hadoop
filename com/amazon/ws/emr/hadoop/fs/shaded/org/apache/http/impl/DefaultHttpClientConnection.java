package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public class DefaultHttpClientConnection
  extends SocketHttpClientConnection
{
  public void bind(Socket socket, HttpParams params)
    throws IOException
  {
    Args.notNull(socket, "Socket");
    Args.notNull(params, "HTTP parameters");
    assertNotOpen();
    socket.setTcpNoDelay(params.getBooleanParameter("http.tcp.nodelay", true));
    socket.setSoTimeout(params.getIntParameter("http.socket.timeout", 0));
    socket.setKeepAlive(params.getBooleanParameter("http.socket.keepalive", false));
    int linger = params.getIntParameter("http.socket.linger", -1);
    if (linger >= 0) {
      socket.setSoLinger(linger > 0, linger);
    }
    super.bind(socket, params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */