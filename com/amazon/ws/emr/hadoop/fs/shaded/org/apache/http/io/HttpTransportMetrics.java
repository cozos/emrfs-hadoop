package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io;

public abstract interface HttpTransportMetrics
{
  public abstract long getBytesTransferred();
  
  public abstract void reset();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpTransportMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */