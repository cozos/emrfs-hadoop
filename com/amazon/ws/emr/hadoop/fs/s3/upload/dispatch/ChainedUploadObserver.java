package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;

final class ChainedUploadObserver
  implements UploadObserver
{
  private final List<UploadObserver> observers;
  
  ChainedUploadObserver(List<UploadObserver> observers)
  {
    this.observers = ImmutableList.copyOf(observers);
  }
  
  public void beforeUploadCompletion(UploadObserverContext context)
    throws IOException
  {
    for (UploadObserver observer : observers) {
      observer.beforeUploadCompletion(context);
    }
  }
  
  public void afterUploadCompletion(UploadObserverContext context)
    throws IOException
  {
    for (UploadObserver observer : observers) {
      observer.afterUploadCompletion(context);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ChainedUploadObserver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */