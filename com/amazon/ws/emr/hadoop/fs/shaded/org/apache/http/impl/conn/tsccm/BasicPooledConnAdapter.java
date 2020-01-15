package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.AbstractPoolEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.AbstractPooledConnAdapter;

@Deprecated
public class BasicPooledConnAdapter
  extends AbstractPooledConnAdapter
{
  protected BasicPooledConnAdapter(ThreadSafeClientConnManager tsccm, AbstractPoolEntry entry)
  {
    super(tsccm, entry);
    markReusable();
  }
  
  protected ClientConnectionManager getManager()
  {
    return super.getManager();
  }
  
  protected AbstractPoolEntry getPoolEntry()
  {
    return super.getPoolEntry();
  }
  
  protected void detach()
  {
    super.detach();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */