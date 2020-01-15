package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

public abstract interface EofSensorWatcher
{
  public abstract boolean eofDetected(InputStream paramInputStream)
    throws IOException;
  
  public abstract boolean streamClosed(InputStream paramInputStream)
    throws IOException;
  
  public abstract boolean streamAbort(InputStream paramInputStream)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.EofSensorWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */