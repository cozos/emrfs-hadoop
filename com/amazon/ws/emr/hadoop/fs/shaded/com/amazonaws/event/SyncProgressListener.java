package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

public abstract class SyncProgressListener
  implements ProgressListener, DeliveryMode
{
  public boolean isSyncCallSafe()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SyncProgressListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */