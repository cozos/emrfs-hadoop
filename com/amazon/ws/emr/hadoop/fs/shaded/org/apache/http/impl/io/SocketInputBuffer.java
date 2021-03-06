package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.EofSensor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public class SocketInputBuffer
  extends AbstractSessionInputBuffer
  implements EofSensor
{
  private final Socket socket;
  private boolean eof;
  
  public SocketInputBuffer(Socket socket, int buffersize, HttpParams params)
    throws IOException
  {
    Args.notNull(socket, "Socket");
    this.socket = socket;
    eof = false;
    int n = buffersize;
    if (n < 0) {
      n = socket.getReceiveBufferSize();
    }
    if (n < 1024) {
      n = 1024;
    }
    init(socket.getInputStream(), n, params);
  }
  
  protected int fillBuffer()
    throws IOException
  {
    int i = super.fillBuffer();
    eof = (i == -1);
    return i;
  }
  
  public boolean isDataAvailable(int timeout)
    throws IOException
  {
    boolean result = hasBufferedData();
    if (!result)
    {
      int oldtimeout = socket.getSoTimeout();
      try
      {
        socket.setSoTimeout(timeout);
        fillBuffer();
        result = hasBufferedData();
      }
      finally
      {
        socket.setSoTimeout(oldtimeout);
      }
    }
    return result;
  }
  
  public boolean isEof()
  {
    return eof;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.SocketInputBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */