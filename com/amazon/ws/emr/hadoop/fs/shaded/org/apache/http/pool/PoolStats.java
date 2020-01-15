package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.Serializable;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class PoolStats
  implements Serializable
{
  private static final long serialVersionUID = -2807686144795228544L;
  private final int leased;
  private final int pending;
  private final int available;
  private final int max;
  
  public PoolStats(int leased, int pending, int free, int max)
  {
    this.leased = leased;
    this.pending = pending;
    available = free;
    this.max = max;
  }
  
  public int getLeased()
  {
    return leased;
  }
  
  public int getPending()
  {
    return pending;
  }
  
  public int getAvailable()
  {
    return available;
  }
  
  public int getMax()
  {
    return max;
  }
  
  public String toString()
  {
    StringBuilder buffer = new StringBuilder();
    buffer.append("[leased: ");
    buffer.append(leased);
    buffer.append("; pending: ");
    buffer.append(pending);
    buffer.append("; available: ");
    buffer.append(available);
    buffer.append("; max: ");
    buffer.append(max);
    buffer.append("]");
    return buffer.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.PoolStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */