package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.pool;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.PoolEntry;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class BasicPoolEntry
  extends PoolEntry<HttpHost, HttpClientConnection>
{
  public BasicPoolEntry(String id, HttpHost route, HttpClientConnection conn)
  {
    super(id, route, conn);
  }
  
  public void close()
  {
    try
    {
      ((HttpClientConnection)getConnection()).close();
    }
    catch (IOException ignore) {}
  }
  
  public boolean isClosed()
  {
    return !((HttpClientConnection)getConnection()).isOpen();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.pool.BasicPoolEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */