package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

class SystemClock
  implements Clock
{
  public long getCurrentTime()
  {
    return System.currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.SystemClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */