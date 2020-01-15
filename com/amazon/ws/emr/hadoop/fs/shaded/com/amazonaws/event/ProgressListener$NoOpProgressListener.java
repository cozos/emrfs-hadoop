package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

public class ProgressListener$NoOpProgressListener
  implements ProgressListener, DeliveryMode
{
  public boolean isSyncCallSafe()
  {
    return true;
  }
  
  public void progressChanged(ProgressEvent progressEvent) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener.NoOpProgressListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */