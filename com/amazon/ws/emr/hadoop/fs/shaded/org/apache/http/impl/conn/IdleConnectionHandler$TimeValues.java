package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;

class IdleConnectionHandler$TimeValues
{
  private final long timeAdded;
  private final long timeExpires;
  
  IdleConnectionHandler$TimeValues(long now, long validDuration, TimeUnit validUnit)
  {
    timeAdded = now;
    if (validDuration > 0L) {
      timeExpires = (now + validUnit.toMillis(validDuration));
    } else {
      timeExpires = Long.MAX_VALUE;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.IdleConnectionHandler.TimeValues
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */