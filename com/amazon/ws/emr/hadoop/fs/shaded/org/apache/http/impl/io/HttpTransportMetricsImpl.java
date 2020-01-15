package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpTransportMetrics;

public class HttpTransportMetricsImpl
  implements HttpTransportMetrics
{
  private long bytesTransferred = 0L;
  
  public long getBytesTransferred()
  {
    return bytesTransferred;
  }
  
  public void setBytesTransferred(long count)
  {
    bytesTransferred = count;
  }
  
  public void incrementBytesTransferred(long count)
  {
    bytesTransferred += count;
  }
  
  public void reset()
  {
    bytesTransferred = 0L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.HttpTransportMetricsImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */