package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface HttpConnectionMetrics
{
  public abstract long getRequestCount();
  
  public abstract long getResponseCount();
  
  public abstract long getSentBytesCount();
  
  public abstract long getReceivedBytesCount();
  
  public abstract Object getMetric(String paramString);
  
  public abstract void reset();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnectionMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */