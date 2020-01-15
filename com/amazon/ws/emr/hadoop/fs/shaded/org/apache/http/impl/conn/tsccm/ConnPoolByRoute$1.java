package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionPoolTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

class ConnPoolByRoute$1
  implements PoolEntryRequest
{
  ConnPoolByRoute$1(ConnPoolByRoute paramConnPoolByRoute, WaitingThreadAborter paramWaitingThreadAborter, HttpRoute paramHttpRoute, Object paramObject) {}
  
  public void abortRequest()
  {
    ConnPoolByRoute.access$000(this$0).lock();
    try
    {
      val$aborter.abort();
    }
    finally
    {
      ConnPoolByRoute.access$000(this$0).unlock();
    }
  }
  
  public BasicPoolEntry getPoolEntry(long timeout, TimeUnit tunit)
    throws InterruptedException, ConnectionPoolTimeoutException
  {
    return this$0.getEntryBlocking(val$route, val$state, timeout, tunit, val$aborter);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.ConnPoolByRoute.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */