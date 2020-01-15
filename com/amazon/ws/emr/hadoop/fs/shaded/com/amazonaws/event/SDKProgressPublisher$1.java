package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

final class SDKProgressPublisher$1
  implements Runnable
{
  SDKProgressPublisher$1(ProgressListener paramProgressListener, ProgressEvent paramProgressEvent) {}
  
  public void run()
  {
    val$listener.progressChanged(val$event);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */