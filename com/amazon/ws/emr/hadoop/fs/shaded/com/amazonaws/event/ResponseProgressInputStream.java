package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import java.io.InputStream;

class ResponseProgressInputStream
  extends ProgressInputStream
{
  ResponseProgressInputStream(InputStream is, ProgressListener listener)
  {
    super(is, listener);
  }
  
  protected void onReset()
  {
    SDKProgressPublisher.publishResponseReset(getListener(), getNotifiedByteCount());
  }
  
  protected void onEOF()
  {
    onNotifyBytesRead();
  }
  
  protected void onNotifyBytesRead()
  {
    SDKProgressPublisher.publishResponseBytesTransferred(getListener(), getUnnotifiedByteCount());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ResponseProgressInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */