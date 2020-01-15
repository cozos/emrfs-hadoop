package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import java.io.IOException;

public abstract interface ConnectionReleaseTrigger
{
  public abstract void releaseConnection()
    throws IOException;
  
  public abstract void abortConnection()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionReleaseTrigger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */