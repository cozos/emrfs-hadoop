package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import java.io.IOException;

public class SingleClientConnManager$PoolEntry
  extends AbstractPoolEntry
{
  protected SingleClientConnManager$PoolEntry(SingleClientConnManager paramSingleClientConnManager)
  {
    super(connOperator, null);
  }
  
  protected void close()
    throws IOException
  {
    shutdownEntry();
    if (connection.isOpen()) {
      connection.close();
    }
  }
  
  protected void shutdown()
    throws IOException
  {
    shutdownEntry();
    if (connection.isOpen()) {
      connection.shutdown();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.SingleClientConnManager.PoolEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */