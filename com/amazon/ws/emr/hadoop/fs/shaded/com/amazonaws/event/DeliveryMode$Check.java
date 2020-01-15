package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

public class DeliveryMode$Check
{
  public static boolean isSyncCallSafe(ProgressListener listener)
  {
    if ((listener instanceof DeliveryMode))
    {
      DeliveryMode mode = (DeliveryMode)listener;
      return mode.isSyncCallSafe();
    }
    return listener == null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.DeliveryMode.Check
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */