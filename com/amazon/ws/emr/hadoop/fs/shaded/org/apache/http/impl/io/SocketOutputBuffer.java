package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public class SocketOutputBuffer
  extends AbstractSessionOutputBuffer
{
  public SocketOutputBuffer(Socket socket, int buffersize, HttpParams params)
    throws IOException
  {
    Args.notNull(socket, "Socket");
    int n = buffersize;
    if (n < 0) {
      n = socket.getSendBufferSize();
    }
    if (n < 1024) {
      n = 1024;
    }
    init(socket.getOutputStream(), n, params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.SocketOutputBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */