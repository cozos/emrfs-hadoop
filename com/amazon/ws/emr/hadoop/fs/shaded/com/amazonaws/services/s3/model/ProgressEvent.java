package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;

@Deprecated
public class ProgressEvent
  extends com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent
{
  public ProgressEvent(int bytesTransferred)
  {
    super(bytesTransferred);
  }
  
  public ProgressEvent(long bytesTransferred)
  {
    super(ProgressEventType.BYTE_TRANSFER_EVENT, bytesTransferred);
  }
  
  public ProgressEvent(ProgressEventType eventType)
  {
    super(eventType);
  }
  
  @Deprecated
  public int getBytesTransfered()
  {
    return (int)getBytesTransferred();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ProgressEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */