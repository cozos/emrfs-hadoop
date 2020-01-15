package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class BasicEofSensorWatcher
  implements EofSensorWatcher
{
  protected final ManagedClientConnection managedConn;
  protected final boolean attemptReuse;
  
  public BasicEofSensorWatcher(ManagedClientConnection conn, boolean reuse)
  {
    Args.notNull(conn, "Connection");
    managedConn = conn;
    attemptReuse = reuse;
  }
  
  public boolean eofDetected(InputStream wrapped)
    throws IOException
  {
    try
    {
      if (attemptReuse)
      {
        wrapped.close();
        managedConn.markReusable();
      }
    }
    finally
    {
      managedConn.releaseConnection();
    }
    return false;
  }
  
  public boolean streamClosed(InputStream wrapped)
    throws IOException
  {
    try
    {
      if (attemptReuse)
      {
        wrapped.close();
        managedConn.markReusable();
      }
    }
    finally
    {
      managedConn.releaseConnection();
    }
    return false;
  }
  
  public boolean streamAbort(InputStream wrapped)
    throws IOException
  {
    managedConn.abortConnection();
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.BasicEofSensorWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */