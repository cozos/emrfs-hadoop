package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import java.io.InputStream;

class RequestProgressInputStream
  extends ProgressInputStream
{
  RequestProgressInputStream(InputStream is, ProgressListener listener)
  {
    super(is, listener);
  }
  
  protected void onReset()
  {
    SDKProgressPublisher.publishRequestReset(getListener(), getNotifiedByteCount());
  }
  
  protected void onEOF()
  {
    onNotifyBytesRead();
  }
  
  protected void onNotifyBytesRead()
  {
    SDKProgressPublisher.publishRequestBytesTransferred(getListener(), getUnnotifiedByteCount());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.RequestProgressInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */