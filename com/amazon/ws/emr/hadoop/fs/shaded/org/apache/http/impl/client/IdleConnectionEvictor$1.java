package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import java.util.concurrent.TimeUnit;

class IdleConnectionEvictor$1
  implements Runnable
{
  IdleConnectionEvictor$1(IdleConnectionEvictor paramIdleConnectionEvictor, HttpClientConnectionManager paramHttpClientConnectionManager) {}
  
  public void run()
  {
    try
    {
      while (!Thread.currentThread().isInterrupted())
      {
        Thread.sleep(IdleConnectionEvictor.access$000(this$0));
        val$connectionManager.closeExpiredConnections();
        if (IdleConnectionEvictor.access$100(this$0) > 0L) {
          val$connectionManager.closeIdleConnections(IdleConnectionEvictor.access$100(this$0), TimeUnit.MILLISECONDS);
        }
      }
    }
    catch (Exception ex)
    {
      IdleConnectionEvictor.access$202(this$0, ex);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.IdleConnectionEvictor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */