package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.DeliveryMode;

@Deprecated
public class LegacyS3ProgressListener
  implements com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener, DeliveryMode
{
  private final ProgressListener listener;
  private final boolean syncCallSafe;
  
  public LegacyS3ProgressListener(ProgressListener listener)
  {
    this.listener = listener;
    if ((listener instanceof DeliveryMode))
    {
      DeliveryMode mode = (DeliveryMode)listener;
      syncCallSafe = mode.isSyncCallSafe();
    }
    else
    {
      syncCallSafe = false;
    }
  }
  
  public ProgressListener unwrap()
  {
    return listener;
  }
  
  public void progressChanged(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent progressEvent)
  {
    if (listener == null) {
      return;
    }
    listener.progressChanged(adaptToLegacyEvent(progressEvent));
  }
  
  private ProgressEvent adaptToLegacyEvent(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent event)
  {
    long bytes = event.getBytesTransferred();
    if (bytes != 0L) {
      return new ProgressEvent(bytes);
    }
    return new ProgressEvent(event.getEventType());
  }
  
  public boolean isSyncCallSafe()
  {
    return syncCallSafe;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.LegacyS3ProgressListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */